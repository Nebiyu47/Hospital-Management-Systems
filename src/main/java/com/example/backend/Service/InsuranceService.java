package com.example.backend.Service;

import com.example.backend.dto.InsuranceDto;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

public interface InsuranceService {
    public InsuranceDto save(InsuranceDto insuranceDto);
    public InsuranceDto getId(Long id) throws Exception;
    public List<InsuranceDto> getAll();
    public InsuranceDto update(InsuranceDto insuranceDto, Long id) throws Exception;
    public Map<String,Boolean> deleted(Long id) throws Exception;
}
