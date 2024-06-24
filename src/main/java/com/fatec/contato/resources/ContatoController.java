package com.fatec.contato.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contato.entities.Contato;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @GetMapping
    public List<Contato> getContatos() {
        Contato s1 = new Contato();
        s1.setId(1);
        s1.setName("Ana");
        s1.setPhone("(11)865577698");
        s1.setDescription("Mãe");
        s1.setEmail("ana25@gmail.com");
        s1.setAddress("Rua Antunes Silva, Salvador");

        Contato s2 = new Contato();
        s2.setId(2);
        s2.setName("Bernardo");
        s2.setPhone("(11)546632479");
        s2.setDescription("Irmão");
        s2.setEmail("bernardosilva@gmail.com");
        s2.setAddress("Rua Floreano Peixoto, Salto");

        Contato s3 = new Contato();
        s3.setId(3);
        s3.setName("Clara");
        s3.setPhone("(11)987745698");
        s3.setDescription("Prima");
        s3.setEmail("claramadeira10@gmail.com");
        s3.setAddress("Rua das Flores, Salvador");

        ArrayList<Contato> lista = new ArrayList<Contato>();
        lista.add(s1);
        lista.add(s2);
        lista.add(s3);

        return lista;
    }
}
