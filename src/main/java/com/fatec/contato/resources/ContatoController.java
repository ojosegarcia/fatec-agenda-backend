package com.fatec.contato.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.contato.dto.ContatoRequest;
import com.fatec.contato.dto.ContatoResponse;
import com.fatec.contato.entities.Contato;
import com.fatec.contato.services.ContatoService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoResponse>> getContatos() {
    return ResponseEntity.ok(contatoService.getContatos());
    }

    @GetMapping("{id}")
    public ResponseEntity<ContatoResponse> getContatoById(@PathVariable int id){
        return ResponseEntity.ok(contatoService.getContatoById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContatoById(@PathVariable int id){
        this.contatoService.deleteContatoById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContatoResponse> save(@RequestBody ContatoRequest contato){
        ContatoResponse newContato = this.contatoService.save(contato);

        URI location = ServletUriComponentsBuilder 
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newContato.id())
        .toUri();
        return ResponseEntity.created(location).body(newContato);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody ContatoRequest contato){
        this.contatoService.update(id, contato);
        return ResponseEntity.ok().build();
    }
}
