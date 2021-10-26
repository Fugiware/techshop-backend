package com.br.techshop.exceptions;

public class EntidadeNaoEncontrada extends Exception { 
    public EntidadeNaoEncontrada(String errorMessage) {
        super(errorMessage);
    }
}