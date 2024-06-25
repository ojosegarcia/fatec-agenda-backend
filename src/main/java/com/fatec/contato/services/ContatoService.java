package com.fatec.contato.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.contato.dto.ContatoRequest;
import com.fatec.contato.dto.ContatoResponse;
import com.fatec.contato.entities.Contato;
import com.fatec.contato.mappers.ContatoMapper;
import com.fatec.contato.repositories.ContatoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<ContatoResponse> getContatos() {

         List <Contato> contatos =contatoRepository.findAll();
         return contatos.stream().map(c -> ContatoMapper.toDTO(c))
                                 .collect(Collectors.toList());

    }

    public ContatoResponse getContatoById(int id) {
        Contato contato= contatoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Contato não encontrado"));
                return ContatoMapper.toDTO(contato);
    }

    public void deleteContatoById(int id) {
        if (this.contatoRepository.existsById(id)) {
            this.contatoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Contato não encontrado");
        }

    }

    public ContatoResponse save(ContatoRequest request) {
        Contato contato= ContatoMapper.toEntity(request);
        return ContatoMapper.toDTO(this.contatoRepository.save(contato));
    }

    public void update(int id, ContatoRequest contato) {
        try {
            Contato aux = contatoRepository.getReferenceById(id);
            aux.setAddress(contato.address());
            aux.setDescription(contato.description());
            aux.setEmail(contato.email());
            aux.setName(contato.name());
            aux.setPhone(contato.phone());
            this.contatoRepository.save(aux);

        } catch (EntityNotFoundException e) {
              throw new EntityNotFoundException("Contato não cadastrado");  
        }
    }
}
