package com.example.backend.dto;

import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Patient;
import com.example.backend.Entity.Ward;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data

public class WardDto {

    private Long id;
    private String wardName;
    private Doctor doctor;
    Patient patient;
    public WardDto(Ward ward){
        this.id=ward.getId();
        this.wardName=ward.getWardName();
        this.doctor=ward.getDoctor();
        this.patient=ward.getPatient();
    }


}
