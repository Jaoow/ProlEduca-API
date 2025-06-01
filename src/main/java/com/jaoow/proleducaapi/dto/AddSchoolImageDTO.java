package com.jaoow.proleducaapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSchoolImageDTO {

    @NotNull(message = "O ID da escola é obrigatório.")
    private Long schoolId;

    @NotBlank(message = "A URL da imagem é obrigatória.")
    @Size(max = 500, message = "A URL deve ter no máximo 500 caracteres.")
    @Pattern(regexp = "^(https?://).+", message = "A URL da imagem deve ser válida e começar com http:// ou https://.")
    private String url;

}
