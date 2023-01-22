package com.example.backend.dto;

import com.example.backend.Entity.Department;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {

    private Long Id;
    private String departmentName;
    public DepartmentDto(Department department){
        this.Id=department.getId();
        this.departmentName=department.getDepartmentName();
    }
}
