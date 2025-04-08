package com.jaoow.proleducaapi.repository;

import com.jaoow.proleducaapi.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findBySlug(String slug);

    boolean existsBySlug(String slug);
}