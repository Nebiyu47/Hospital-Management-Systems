package com.example.backend.Repository;

import com.example.backend.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query(value = "select * from #{#entityName} d where d.DEP_Id=?1",nativeQuery = true)
    public Department getByd(Long id);
}
