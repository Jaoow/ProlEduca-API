package com.jaoow.proleducaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseViewDTO {
    
    private Long id;
    private Long schoolId;
    private String name;
    private String description;
    private BigDecimal monthlyPrice;
}
