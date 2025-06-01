package com.jaoow.proleducaapi.exception;

public class SchoolAlreadyExistsException extends RuntimeException {
    public SchoolAlreadyExistsException(String slug) {
        super("Escola com slug '" + slug + "' já existe.");
    }

}
