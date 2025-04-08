package com.jaoow.proleducaapi.service;

import com.jaoow.proleducaapi.dto.AddSchoolImageDTO;
import com.jaoow.proleducaapi.dto.SchoolImageViewDTO;
import com.jaoow.proleducaapi.exception.SchoolNotFoundException;
import com.jaoow.proleducaapi.model.School;
import com.jaoow.proleducaapi.model.SchoolImage;
import com.jaoow.proleducaapi.repository.ImageRepository;
import com.jaoow.proleducaapi.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchoolImageService {

    private final ImageRepository imageRepository;
    private final SchoolRepository schoolRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public SchoolImageViewDTO createSchoolImage(AddSchoolImageDTO addSchoolImageDTO, String schoolSlug) {
        School school = schoolRepository.findBySlug(schoolSlug)
                .orElseThrow(() -> new SchoolNotFoundException(schoolSlug));

        SchoolImage schoolImage = modelMapper.map(addSchoolImageDTO, SchoolImage.class);
        schoolImage.setSchool(school);

        SchoolImage saveImage = imageRepository.save(schoolImage);
        return modelMapper.map(saveImage, SchoolImageViewDTO.class);
    }

    public List<SchoolImageViewDTO> getImagesBySchool(String schoolSlug) {
        return imageRepository.findBySchoolSlug(schoolSlug)
                .stream()
                .map(SchoolImage -> modelMapper.map(SchoolImage, SchoolImageViewDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteSchoolImage(String schoolSlug, Long id) {
        imageRepository.deleteByIdAndSchoolSlug(id, schoolSlug);
    }
}
