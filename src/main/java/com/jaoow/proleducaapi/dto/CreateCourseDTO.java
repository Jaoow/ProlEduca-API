package com.jaoow.proleducaapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDTO {

    @NotNull(message = "O ID da escola é obrigatório.")
    private Long schoolId;

    @NotBlank(message = "O nome do curso é obrigatório.")
    @Size(max = 255, message = "O nome do curso deve ter no máximo 255 caracteres.")
    private String name;

    @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    private String description;

    @NotNull(message = "O preço mensal é obrigatório.")
    @Min(value = 0, message = "O preço mensal deve ser um valor positivo.")
    private BigDecimal monthlyPrice;
}
