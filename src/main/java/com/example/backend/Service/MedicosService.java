package com.example.backend.Service;

import com.example.backend.dto.MedicosDto;

import java.util.List;
import java.util.Map;

public interface MedicosService {
    public MedicosDto save(MedicosDto medicosDto);
    public MedicosDto update(MedicosDto medicosDto,Long id) throws Exception;
    public MedicosDto getById(Long id) throws Exception;
    public List<MedicosDto>getAll();
    public Map<String,Boolean> deleted(Long id)throws Exception;
    public List<MedicosDto>getByPatientId(Long id) throws Exception;
    public Long getTotal(Long id);
}
