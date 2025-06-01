package com.jaoow.proleducaapi.exception;

public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException(String slug) {
        super("Escola com slug '" + slug + "' não encontrada.");
    }

    public SchoolNotFoundException(Long id) {
        super("Escola com ID '" + id + "' não encontrada.");
    }
}
