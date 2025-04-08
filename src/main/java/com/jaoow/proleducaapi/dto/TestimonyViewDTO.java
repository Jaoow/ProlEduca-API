package com.jaoow.proleducaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonyViewDTO {
    private Long id;
    private Long schoolId;
    private Long courseId;
    private String author;
    private int rating;
    private LocalDate date;
    private String comment;
}
