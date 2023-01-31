package com.example.backend.Repository;

import com.example.backend.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {


    @Query(value = "select * from #{#entityName} o where o.ope_id=?1",nativeQuery = true)
    public Operation getById(Long id);
}
