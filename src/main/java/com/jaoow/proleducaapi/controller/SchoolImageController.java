package com.jaoow.proleducaapi.controller;

import com.jaoow.proleducaapi.dto.AddSchoolImageDTO;
import com.jaoow.proleducaapi.dto.SchoolImageViewDTO;
import com.jaoow.proleducaapi.service.SchoolImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school/{schoolSlug}/image")
public class SchoolImageController {

    private final SchoolImageService schoolImageService;

    @GetMapping
    public List<SchoolImageViewDTO> getTestimoniesBySchool(@PathVariable String schoolSlug) {
        return schoolImageService.getImagesBySchool(schoolSlug);
    }

    @PostMapping
    public SchoolImageViewDTO createSchoolImage(@PathVariable String schoolSlug, @RequestBody AddSchoolImageDTO addSchoolImageDTO) {
        return schoolImageService.createSchoolImage(addSchoolImageDTO, schoolSlug);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolImage(@PathVariable String schoolSlug, @PathVariable Long id) {
        schoolImageService.deleteSchoolImage(schoolSlug, id);
    }
}
