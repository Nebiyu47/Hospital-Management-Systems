package com.example.backend.Service;

import com.example.backend.dto.OperationDto;

import java.util.List;
import java.util.Map;

public interface OperationService {
    public OperationDto save(OperationDto operationDto);
    public OperationDto update(OperationDto operationDto ,Long id) throws Exception;
    public  OperationDto getById(Long id) throws Exception;
    public List<OperationDto> getAll();
    public Map<String,Boolean> deleted(Long id)throws Exception;
}
