package com.jaoow.proleducaapi.service;

import com.jaoow.proleducaapi.dto.CreateTestimonyDTO;
import com.jaoow.proleducaapi.dto.TestimonyViewDTO;
import com.jaoow.proleducaapi.exception.CourseNotFoundException;
import com.jaoow.proleducaapi.exception.SchoolNotFoundException;
import com.jaoow.proleducaapi.exception.TestimonyNotFoundException;
import com.jaoow.proleducaapi.model.Course;
import com.jaoow.proleducaapi.model.School;
import com.jaoow.proleducaapi.model.Testimony;
import com.jaoow.proleducaapi.repository.CourseRepository;
import com.jaoow.proleducaapi.repository.SchoolRepository;
import com.jaoow.proleducaapi.repository.TestimonyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestimonyService {

    private final TestimonyRepository testimonyRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;

    @Transactional
    public TestimonyViewDTO createTestimony(CreateTestimonyDTO createTestimonyDTO, String schoolSlug) {
        School school = schoolRepository.findBySlug(schoolSlug)
                .orElseThrow(() -> new SchoolNotFoundException(schoolSlug));

        Course course = courseRepository.findById(createTestimonyDTO.getCourseId())
                .orElseThrow(() -> new CourseNotFoundException(createTestimonyDTO.getCourseId()));

        Testimony testimony = modelMapper.map(createTestimonyDTO, Testimony.class);
        testimony.setSchool(school);
        testimony.setCourse(course);

        testimony.setId(null);

        Testimony savedTestimony = testimonyRepository.save(testimony);
        return modelMapper.map(savedTestimony, TestimonyViewDTO.class);
    }

    public List<TestimonyViewDTO> getTestimoniesBySchool(String schoolSlug) {
        return testimonyRepository.findBySchoolSlug(schoolSlug)
                .stream()
                .map(testimony -> modelMapper.map(testimony, TestimonyViewDTO.class))
                .collect(Collectors.toList());
    }

    public TestimonyViewDTO getTestimonyById(String schoolSlug, Long id) {
        Testimony testimony = testimonyRepository.findByIdAndSchoolSlug(id, schoolSlug)
                .orElseThrow(() -> new TestimonyNotFoundException(id));
        return modelMapper.map(testimony, TestimonyViewDTO.class);
    }

    @Transactional
    public TestimonyViewDTO updateTestimony(Long id, CreateTestimonyDTO createTestimonyDTO, String schoolSlug) {
        Testimony testimony = testimonyRepository.findByIdAndSchoolSlug(id, schoolSlug)
                .orElseThrow(() -> new TestimonyNotFoundException(id));

        modelMapper.map(createTestimonyDTO, testimony);
        Testimony updatedTestimony = testimonyRepository.save(testimony);
        return modelMapper.map(updatedTestimony, TestimonyViewDTO.class);
    }

    @Transactional
    public void deleteTestimony(String schoolSlug, Long id) {
        Testimony testimony = testimonyRepository.findByIdAndSchoolSlug(id, schoolSlug)
                .orElseThrow(() -> new TestimonyNotFoundException(id));
        testimonyRepository.delete(testimony);
    }
}
