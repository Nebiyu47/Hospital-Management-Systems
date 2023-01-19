package com.example.backend.dto;

import com.example.backend.Entity.Department;

import com.example.backend.Entity.Employee;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private Long mobileNumber;
    private String employeeName;
    private String employeeAddress;
    private Department department;

   public EmployeeDto(Employee employee){
       this.id=employee.getId();
       this.mobileNumber=employee.getMobileNumber();
       this.employeeName=employee.getEmployeeName();
       this.employeeAddress=employee.getEmployeeAddress();
       this.department=employee.getDepartment();
   }
}
