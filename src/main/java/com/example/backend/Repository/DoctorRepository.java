package com.example.backend.Repository;


import com.example.backend.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query(value = "select * from #{#entityName} d where d.Doc_id=?1",nativeQuery = true)
    public Doctor getById(Long id);
    @Query(value = "select * from #{#entityName} d where d.doctorPhoneNo=?1",nativeQuery = true)
    public Doctor existsByDoctorPhoneNumber(Long phoneNumber);


}
