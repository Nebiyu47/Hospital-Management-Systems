package com.example.backend.Repository;


import com.example.backend.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {



    public Doctor existsByDoctorPhoneNumber(Long phoneNumber);


}
