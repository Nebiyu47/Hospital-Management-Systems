package com.example.backend.Repository;

import com.example.backend.Entity.Patient;
import com.example.backend.dto.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "select *from #{#entityName} p where p.pat_id=?1",nativeQuery = true)
    public  Patient getById(Long id);
    @Query(value = "select * from #{#entityName} p where p.mobileNumber=?1",nativeQuery = true)
    public Patient existsByPhoneNumber(Long id);
}
