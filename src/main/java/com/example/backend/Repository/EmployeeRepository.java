package com.example.backend.Repository;


import com.example.backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee existsByPhoneNumber(Long id);

}
