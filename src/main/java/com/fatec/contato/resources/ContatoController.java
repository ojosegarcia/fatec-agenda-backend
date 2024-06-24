package com.fatec.contato.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contato.entities.Contato;
import com.fatec.contato.services.ContatoService;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;
    @GetMapping
    public List<Contato> getContatos() {
    return contatoService.getContatos();
    }
}
