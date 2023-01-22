package com.example.backend.Service;

import com.example.backend.dto.DoctorDto;

import java.util.List;
import java.util.Map;

public interface DoctorService {
    public DoctorDto save(DoctorDto doctorDto);
    public DoctorDto update(DoctorDto doctorDto, Long id) throws Exception;
    public DoctorDto getById(Long iD) throws Exception;
    public List<DoctorDto>getAll();
    public Map<String, Boolean> deleted(Long id) throws Exception;
    public  boolean existsByNumber(DoctorDto doctorDto);
}
