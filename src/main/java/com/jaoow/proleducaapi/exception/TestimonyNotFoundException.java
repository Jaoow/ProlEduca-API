package com.jaoow.proleducaapi.exception;

public class TestimonyNotFoundException extends RuntimeException {

    public TestimonyNotFoundException(Long id) {
        super("Testemunho com ID '" + id + "' não encontrada.");
    }
}
