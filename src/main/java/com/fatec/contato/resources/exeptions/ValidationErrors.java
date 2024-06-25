package com.fatec.contato.resources.exeptions;

import java.util.ArrayList;
import java.util.List;



public class ValidationErrors extends StanderdError {
    private List<String> errors = new ArrayList<>();

    public void addError(String error){
        this.errors.add(error);
    }

    public List<String> getErrors(){
        return this.errors;
    }
}
