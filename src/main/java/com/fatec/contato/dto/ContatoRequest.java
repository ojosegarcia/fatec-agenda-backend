package com.fatec.contato.dto;

import org.hibernate.validator.constraints.pl.NIP;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoRequest (
    @NotNull (message = "Nome não pode ser nulo")
    String name, 
    @NotBlank (message = "telefone não pode ser nulo")
    String phone, 
    @NotNull (message = "descrição não pode ser nulo")
    String description, 
    @NotNull (message = "email não pode ser nulo")
    String email, 
    @NotNull (message = "endereço não pode ser nulo")
    String address
    ) {
    
}
