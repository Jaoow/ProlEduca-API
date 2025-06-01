package com.jaoow.proleducaapi.service;

import com.jaoow.proleducaapi.dto.CreateCourseDTO;
import com.jaoow.proleducaapi.dto.CourseViewDTO;
import com.jaoow.proleducaapi.dto.SchoolViewDTO;
import com.jaoow.proleducaapi.exception.CourseNotFoundException;
import com.jaoow.proleducaapi.exception.SchoolNotFoundException;
import com.jaoow.proleducaapi.model.Course;
import com.jaoow.proleducaapi.model.School;
import com.jaoow.proleducaapi.repository.CourseRepository;
import com.jaoow.proleducaapi.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public CourseViewDTO createCourse(CreateCourseDTO createCourseDTO, String schoolSlug) {
        School school = schoolRepository.findBySlug(schoolSlug)
                .orElseThrow(() -> new SchoolNotFoundException(schoolSlug));

        Course course = modelMapper.map(createCourseDTO, Course.class);
        course.setSchool(school);
        course.setId(null);

        Course savedCourse = courseRepository.save(course);
        return modelMapper.map(savedCourse, CourseViewDTO.class);
    }

    @Transactional
    public CourseViewDTO updateCourse(Long id, CreateCourseDTO createCourseDTO, String schoolSlug) {
        Course course = courseRepository.findByIdAndSchoolSlug(id, schoolSlug)
                .orElseThrow(() -> new CourseNotFoundException(id));

        modelMapper.map(createCourseDTO, course);
        Course updatedCourse = courseRepository.save(course);
        return modelMapper.map(updatedCourse, CourseViewDTO.class);
    }

    public CourseViewDTO getCourseById(String schoolSlug, Long id) {
        return courseRepository.findByIdAndSchoolSlug(id, schoolSlug)
                .map(course -> modelMapper.map(course, CourseViewDTO.class))
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    public List<CourseViewDTO> getCoursesBySchool(String schoolSlug) {
        return courseRepository.findAllBySchoolSlug(schoolSlug)
                .stream()
                .map(course -> modelMapper.map(course, CourseViewDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCourse(String schoolSlug, Long id) {
        courseRepository.deleteByIdAndSchoolSlug(id, schoolSlug);
    }
}
