package com.example.backend.Repository;


import com.example.backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from #{#entityName} e where e.id=?1",nativeQuery = true)
    public Employee getById(Long empId);
    @Query(value = "select * from #{#entityName} e where e.id=?1" , nativeQuery=true)
    public Employee existsByPhoneNumber(Long id);

}
