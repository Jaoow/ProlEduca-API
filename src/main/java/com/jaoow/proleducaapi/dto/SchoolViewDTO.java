package com.jaoow.proleducaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolViewDTO {
    
    private Long id;
    private String slug;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String website;
    private String logoUrl;
    private AddressDTO address;
}
