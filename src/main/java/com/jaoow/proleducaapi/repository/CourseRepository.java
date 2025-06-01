package com.jaoow.proleducaapi.repository;

import com.jaoow.proleducaapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByIdAndSchoolSlug(Long id, String schoolSlug);

    List<Course> findAllBySchoolSlug(String schoolSlug);

    void deleteByIdAndSchoolSlug(Long id, String schoolSlug);
}