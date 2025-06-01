package com.jaoow.proleducaapi.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestimonyDTO {

    @NotNull(message = "O ID da escola é obrigatório.")
    private Long schoolId;

    @NotNull(message = "O ID do curso é obrigatório.")
    private Long courseId;

    @NotBlank(message = "O nome do autor é obrigatório.")
    @Size(max = 255, message = "O nome do autor deve ter no máximo 255 caracteres.")
    private String author;

    @NotNull(message = "A data do depoimento é obrigatória.")
    private LocalDate date;

    @Min(value = 1, message = "A avaliação deve ser no mínimo 1.")
    @Max(value = 5, message = "A avaliação deve ser no máximo 5.")
    private int rating;

    @NotBlank(message = "O texto do depoimento é obrigatório.")
    @Size(max = 1000, message = "O depoimento deve ter no máximo 1000 caracteres.")
    private String comment;
}
