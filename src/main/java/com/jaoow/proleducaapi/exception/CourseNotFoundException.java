package com.jaoow.proleducaapi.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("Curso com ID '" + id + "' não encontrada.");
    }
}
