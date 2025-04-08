package com.jaoow.proleducaapi.controller;

import com.jaoow.proleducaapi.dto.CreateTestimonyDTO;
import com.jaoow.proleducaapi.dto.TestimonyViewDTO;
import com.jaoow.proleducaapi.service.TestimonyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school/{schoolSlug}/testimony")
public class TestimonyController {

    private final TestimonyService testimonyService;

    @GetMapping
    public List<TestimonyViewDTO> getTestimoniesBySchool(@PathVariable String schoolSlug) {
        return testimonyService.getTestimoniesBySchool(schoolSlug);
    }

    @GetMapping("/{id}")
    public TestimonyViewDTO getTestimonyById(@PathVariable String schoolSlug, @PathVariable Long id) {
        return testimonyService.getTestimonyById(schoolSlug, id);
    }

    @PostMapping
    public TestimonyViewDTO createTestimony(@PathVariable String schoolSlug, @RequestBody CreateTestimonyDTO createTestimonyDTO) {
        return testimonyService.createTestimony(createTestimonyDTO, schoolSlug);
    }

    @PutMapping("/{id}")
    public TestimonyViewDTO updateTestimony(@PathVariable String schoolSlug, @PathVariable Long id, @RequestBody CreateTestimonyDTO createTestimonyDTO) {
        return testimonyService.updateTestimony(id, createTestimonyDTO, schoolSlug);
    }

    @DeleteMapping("/{id}")
    public void deleteTestimony(@PathVariable String schoolSlug, @PathVariable Long id) {
        testimonyService.deleteTestimony(schoolSlug, id);
    }
}
