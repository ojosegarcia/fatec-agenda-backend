package com.fatec.contato.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contato.entities.Contato;
import com.fatec.contato.services.ContatoService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> getContatos() {
    return contatoService.getContatos();
    }

    @GetMapping("{id}")
    public Contato getContatoById(@PathVariable int id){
        return contatoService.getContatoByContato(id);
    }

    @DeleteMapping("{id}")
    public void deleteContatoById(@PathVariable int id){
        this.contatoService.deleteContatoById(id);
    }

    @PostMapping
    public Contato save(@RequestBody Contato contato){
        return this.contatoService.save(contato);
    }
}
