package com.jaoow.proleducaapi.repository;

import com.jaoow.proleducaapi.model.Testimony;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {
    List<Testimony> findBySchoolSlug(String schoolSlug);

    Optional<Testimony> findByIdAndSchoolSlug(Long id, String schoolSlug);
}
