package com.example.backend.Repository;

import com.example.backend.Entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Long> {
    @Query(value = "SELECT * FROM #{#entityName} S WHERE S.Spec_id=?1",nativeQuery = true )
    public Specialization getById(Long id);
}
