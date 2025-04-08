package com.jaoow.proleducaapi.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
    private String street; // Rua
    private String number; // Número
    private String neighborhood; // Bairro
    private String city; // Cidade
    private String state; // UF
    private String zipCode; // CEP
}
