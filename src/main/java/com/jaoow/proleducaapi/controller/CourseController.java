package com.jaoow.proleducaapi.controller;

import com.jaoow.proleducaapi.dto.CourseViewDTO;
import com.jaoow.proleducaapi.dto.CreateCourseDTO;
import com.jaoow.proleducaapi.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/school/{schoolSlug}/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<CourseViewDTO> getCoursesBySchool(@PathVariable String schoolSlug) {
        return courseService.getCoursesBySchool(schoolSlug);
    }

    @GetMapping("/{id}")
    public CourseViewDTO getCourseById(@PathVariable String schoolSlug, @PathVariable Long id) {
        return courseService.getCourseById(schoolSlug, id);
    }

    @PostMapping
    public CourseViewDTO createCourse( @PathVariable String schoolSlug, @RequestBody CreateCourseDTO createCourseDTO) {
        return courseService.createCourse(createCourseDTO, schoolSlug);
    }

    @PutMapping("/{id}")
    public CourseViewDTO updateCourse(@PathVariable String schoolSlug, @PathVariable Long id, @RequestBody CreateCourseDTO createCourseDTO) {
        return courseService.updateCourse(id, createCourseDTO, schoolSlug);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String schoolSlug, @PathVariable Long id) {
        courseService.deleteCourse(schoolSlug, id);
    }
}
