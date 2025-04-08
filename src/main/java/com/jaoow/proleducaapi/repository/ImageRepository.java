package com.jaoow.proleducaapi.repository;

import com.jaoow.proleducaapi.model.SchoolImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<SchoolImage, Long> {

    List<SchoolImage> findBySchoolSlug(String schoolSlug);

    Optional<SchoolImage> findByIdAndSchoolSlug(Long id, String schoolSlug);

    void deleteByIdAndSchoolSlug(Long id, String schoolSlug);
}