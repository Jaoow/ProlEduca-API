package com.jaoow.proleducaapi.service;

import com.jaoow.proleducaapi.dto.CreateSchoolDTO;
import com.jaoow.proleducaapi.dto.SchoolViewDTO;
import com.jaoow.proleducaapi.exception.SchoolAlreadyExistsException;
import com.jaoow.proleducaapi.exception.SchoolNotFoundException;
import com.jaoow.proleducaapi.model.School;
import com.jaoow.proleducaapi.repository.SchoolRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public SchoolViewDTO createSchool(CreateSchoolDTO createSchoolDTO) {
        // Check if a school with the same slug already exists
        if (schoolRepository.existsBySlug(createSchoolDTO.getSlug())) {
            throw new SchoolAlreadyExistsException(createSchoolDTO.getSlug());
        }

        School school = modelMapper.map(createSchoolDTO, School.class);
        School savedSchool = schoolRepository.save(school);
        return modelMapper.map(savedSchool, SchoolViewDTO.class);
    }

    @Transactional
    public SchoolViewDTO updateSchool(Long id, CreateSchoolDTO createSchoolDTO) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new SchoolNotFoundException(id));

        modelMapper.map(createSchoolDTO, school);
        School updatedSchool = schoolRepository.save(school);
        return modelMapper.map(updatedSchool, SchoolViewDTO.class);
    }

    public List<SchoolViewDTO> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(school -> modelMapper.map(school, SchoolViewDTO.class))
                .collect(Collectors.toList());
    }

    public SchoolViewDTO getSchoolBySlug(String slug) {
        return schoolRepository.findBySlug(slug)
                .map(school -> modelMapper.map(school, SchoolViewDTO.class))
                .orElseThrow(() -> new SchoolNotFoundException(slug));
    }

    public SchoolViewDTO getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .map(school -> modelMapper.map(school, SchoolViewDTO.class))
                .orElseThrow(() -> new SchoolNotFoundException(id));
    }

    @Transactional
    public void deleteSchool(Long id) {
        if (!schoolRepository.existsById(id)) {
            throw new SchoolNotFoundException(id);
        }
        schoolRepository.deleteById(id);
    }

}
