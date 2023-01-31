package com.example.backend.Repository;

import com.example.backend.Entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    @Query(value = "SELECT * FROM #{#entityName} W WHERE W.war_id=?1",nativeQuery = true)
    public Ward getById(Long id);
}
