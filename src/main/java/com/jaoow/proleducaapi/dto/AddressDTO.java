package com.jaoow.proleducaapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "A rua é obrigatória.")
    @Size(max = 255, message = "A rua deve ter no máximo 255 caracteres.")
    private String street;

    @NotBlank(message = "A cidade é obrigatória.")
    @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres.")
    private String city;

    @NotBlank(message = "O estado é obrigatório.")
    @Size(max = 100, message = "O estado deve ter no máximo 100 caracteres.")
    private String state;

    @NotBlank(message = "O bairro é obrigatório.")
    @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres.")
    private String neighborhood;

    @NotBlank(message = "O número é obrigatório.")
    @Size(max = 10, message = "O número deve ter no máximo 10 caracteres.")
    private String number;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "^[0-9]{5}-?[0-9]{3}$", message = "O CEP deve estar no formato 00000-000 ou 00000000.")
    private String zipCode;

}
