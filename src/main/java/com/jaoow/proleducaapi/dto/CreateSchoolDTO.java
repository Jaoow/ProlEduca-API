package com.jaoow.proleducaapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSchoolDTO {

    @NotBlank(message = "O slug é obrigatório.")
    @Size(max = 100, message = "O slug deve ter no máximo 100 caracteres.")
    @Pattern(regexp = "^[a-z0-9-]+$", message = "O slug deve conter apenas letras minúsculas, números e hífens.")
    private String slug;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres.")
    private String name;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    private String description;

    @Valid
    @NotNull(message = "O endereço é obrigatório.")
    private AddressDTO address;

    @Pattern(regexp = "^\\+?[0-9]{8,15}$", message = "O telefone deve ter entre 8 e 15 dígitos e pode começar com '+'.")
    private String phone;

    @Email(message = "E-mail inválido.")
    @Size(max = 255, message = "O e-mail deve ter no máximo 255 caracteres.")
    private String email;

    @NotBlank(message = "A URL do logo é obrigatória.")
    @Size(max = 500, message = "A URL do logo deve ter no máximo 500 caracteres.")
    @Pattern(regexp = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$", message = "URL inválida.")
    private String logoUrl;

    @Size(max = 255, message = "O site deve ter no máximo 255 caracteres.")
    @Pattern(regexp = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$", message = "URL inválida.")
    private String website;

     @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "^\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}$", message = "CNPJ inválido. Formato esperado: XX.XXX.XXX/XXXX-XX ou XXXXXXXXXXXXXX")
    private String cnpj;

    @NotBlank(message = "O tipo da escola é obrigatório (Publica/Privada).")
    @Pattern(regexp = "^(Publica|Privada)$", message = "Tipo deve ser 'Publica' ou 'Privada'.")
    private String type; // Publica ou Privada

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres.")
    private String password; // Para o "usuário" da escola
}
