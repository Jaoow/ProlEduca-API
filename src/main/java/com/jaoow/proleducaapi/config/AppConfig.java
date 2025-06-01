package com.jaoow.proleducaapi.config;

import com.jaoow.proleducaapi.dto.CreateSchoolDTO;
import com.jaoow.proleducaapi.dto.SchoolViewDTO;
import com.jaoow.proleducaapi.model.School;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();

        // Ignore ambiguity in mapping
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        // This mapping is for School to SchoolViewDTO
        modelMapper.addMappings(new PropertyMap<School, SchoolViewDTO>() {
            @Override
            protected void configure() {
                map().getAddress().setCity(source.getAddress().getCity());
                map().getAddress().setState(source.getAddress().getState());
                map().getAddress().setStreet(source.getAddress().getStreet());
                map().getAddress().setZipCode(source.getAddress().getZipCode());
                map().getAddress().setNeighborhood(source.getAddress().getNeighborhood());
            }
        });

        // This mapping is for CreateSchoolDTO to School
        modelMapper.addMappings(new PropertyMap<CreateSchoolDTO, School>() {
            @Override
            protected void configure() {
                map().getAddress().setCity(source.getAddress().getCity());
                map().getAddress().setState(source.getAddress().getState());
                map().getAddress().setStreet(source.getAddress().getStreet());
                map().getAddress().setZipCode(source.getAddress().getZipCode());
                map().getAddress().setNeighborhood(source.getAddress().getNeighborhood());
            }
        });

        return modelMapper;
    }
}
