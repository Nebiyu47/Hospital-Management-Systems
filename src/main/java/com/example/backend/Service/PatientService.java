package com.example.backend.Service;

import com.example.backend.dto.PatientDto;

import java.util.List;
import java.util.Map;

public interface PatientService {
        public PatientDto save(PatientDto patientDto);
        public PatientDto update(PatientDto patientDto,Long id) throws Exception;
        public PatientDto getById(Long id)throws Exception;
        public List<PatientDto> getAll();
        public Map<String ,Boolean> deleted(Long id) throws Exception;
        public boolean isExistPatient(PatientDto patientDto);
}
