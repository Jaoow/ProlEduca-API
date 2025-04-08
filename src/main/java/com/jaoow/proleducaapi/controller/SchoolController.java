package com.jaoow.proleducaapi.controller;

import com.jaoow.proleducaapi.dto.CreateSchoolDTO;
import com.jaoow.proleducaapi.dto.SchoolViewDTO;
import com.jaoow.proleducaapi.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    private List<SchoolViewDTO> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{slug}")
    private SchoolViewDTO getSchoolBySlug(@PathVariable String slug) {
        return schoolService.getSchoolBySlug(slug);
    }

    @GetMapping("/id/{id}")
    private SchoolViewDTO getSchoolById(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @PostMapping
    private SchoolViewDTO createSchool(@Valid @RequestBody CreateSchoolDTO createSchoolDTO) {
        return schoolService.createSchool(createSchoolDTO);
    }

    @PutMapping("/{id}")
    private SchoolViewDTO updateSchool(@PathVariable Long id, @Valid @RequestBody CreateSchoolDTO createSchoolDTO) {
        return schoolService.updateSchool(id, createSchoolDTO);
    }

    @DeleteMapping("/{id}")
    private void deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }
}
