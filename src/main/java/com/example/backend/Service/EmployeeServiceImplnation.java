package com.example.backend.Service;

import com.example.backend.Entity.Employee;
import com.example.backend.Repository.EmployeeRepository;
import com.example.backend.dto.EmployeeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmployeeServiceImplnation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee convertDtoToModel(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employee.setDepartment(employeeDto.getDepartment());


        return employee;
    }

    private EmployeeDto convertModelToDto(Employee employee) {
        return new EmployeeDto(employee);

    }


    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(convertDtoToModel(employeeDto));
        return convertModelToDto(employee);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto, Long id) throws Exception {

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new Exception("Id is not Found" + id));
        employee.setId(employeeDto.getId());
        employee.setMobileNumber(employeeDto.getMobileNumber());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employee.setDepartment(employeeDto.getDepartment());
        EmployeeDto employeeDto1 = convertModelToDto(employeeRepository.save(employee));
        return employeeDto1;

    }

    @Override
    public EmployeeDto getById(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new Exception("ID Is not is found" + id));
        return convertModelToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeDtoList.add(convertModelToDto(employee));
        }
        return employeeDtoList;
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws Exception {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new Exception("Id is Not Found" + id));
        employeeRepository.delete(employee);
        EmployeeDto employeeDto= convertModelToDto(employee);
        Map<String, Boolean> map = new HashMap<>();
        map.put("id is Found", Boolean.TRUE);
        return map;
    }

    @Override
    public Boolean isExistByNumber(EmployeeDto employeeDto) {

        Employee employee = employeeRepository.existsByPhoneNumber(employeeDto.getMobileNumber());
        if (employee != null) {
            return true;
        } else {
            return false;

        }


    }
}
