package com.example.backend.Repository;

import com.example.backend.Entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {
    @Query(value = "select * from #{#entityName} t where t.id=?1",nativeQuery = true)
    public Test getById(Long id);
}
