package com.fatec.contato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.contato.entities.Contato;
import com.fatec.contato.repositories.ContatoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> getContatos() {
        return contatoRepository.findAll();

    }

    public Contato getContatoByContato(int id) {
        return contatoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Contato não encontrado"));
    }

    public void deleteContatoById(int id) {
        if (this.contatoRepository.existsById(id)) {
            this.contatoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não encontrado");
        }

    }

    public Contato save(Contato contato) {
        return this.contatoRepository.save(contato);
    }

    public void update(int id, Contato contato) {
        try {
            Contato aux = contatoRepository.getReferenceById(id);
            aux.setAddress(contato.getAddress());
            aux.setDescription(contato.getDescription());
            aux.setEmail(contato.getEmail());
            aux.setName(contato.getName());
            aux.setPhone(contato.getPhone());
            this.contatoRepository.save(aux);

        } catch (Exception e) {
              throw new EntityNotFoundException("Contato não cadastrado");  
        }
    }
}
