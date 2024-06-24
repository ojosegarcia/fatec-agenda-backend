package com.fatec.contato.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.contato.entities.Contato;
import com.fatec.contato.repositories.ContatoRepository;

@Service
public class ContatoService {
 @Autowired
 private ContatoRepository  contatoRepository;

 public List<Contato> getContatos(){
    return  contatoRepository.findAll();
 }
}
