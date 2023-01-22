package com.example.backend.Service;

import com.example.backend.dto.DepartmentDto;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public DepartmentDto save(DepartmentDto department);
    public DepartmentDto update(DepartmentDto department, Long id) throws Exception;
    public DepartmentDto getById( long id) throws  Exception;
    public List<DepartmentDto> getAll();
    public Map<String,Boolean> delete( Long id) throws Exception;
}
