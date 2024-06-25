package com.fatec.contato.mappers;

import com.fatec.contato.dto.ContatoRequest;
import com.fatec.contato.dto.ContatoResponse;
import com.fatec.contato.entities.Contato;

public class ContatoMapper {
    
    public static Contato toEntity(ContatoRequest request){
        Contato contato = new Contato();
        contato.setAddress(request.address());
        contato.setDescription(request.description());
        contato.setEmail(request.email());
        contato.setName(request.name());
        contato.setPhone(request.phone());
        return contato;
    }
    public static ContatoResponse toDTO(Contato contato){
        return new ContatoResponse(contato.getId(),
                                   contato.getAddress(),      
                                   contato.getDescription(),
                                   contato.getEmail(),
                                   contato.getName(),
                                   contato.getPhone()      
        );
    }
}
