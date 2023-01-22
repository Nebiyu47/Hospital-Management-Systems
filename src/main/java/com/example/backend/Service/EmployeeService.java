package com.example.backend.Service;

import com.example.backend.dto.EmployeeDto;

import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public EmployeeDto save(EmployeeDto employeeDto);
    public EmployeeDto update(EmployeeDto employeeDto, Long id) throws Exception;
    public EmployeeDto getById(Long id) throws Exception;
    public List<EmployeeDto> getAll();
    public Map<String,Boolean> delete(Long id) throws Exception;
    public Boolean isExistByNumber(EmployeeDto employeeDto);

}
