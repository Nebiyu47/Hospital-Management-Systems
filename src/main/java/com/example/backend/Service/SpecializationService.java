package com.example.backend.Service;

import com.example.backend.Entity.Specialization;
import com.example.backend.dto.SpecializationDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SpecializationService {
    public SpecializationDto save(SpecializationDto specializationDto);
    public SpecializationDto update(SpecializationDto specializationDto, Long id) throws Exception;
    public SpecializationDto getById(Long id) throws Exception;
    public List<SpecializationDto> getAll();
    public Map<String,Boolean> deleted(Long id) throws Exception;

}
