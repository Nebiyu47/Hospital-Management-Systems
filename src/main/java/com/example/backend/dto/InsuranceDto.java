package com.example.backend.dto;

import com.example.backend.Entity.Insurance;
import com.example.backend.Entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class InsuranceDto {

    private Long id;
    private double billAmount;
    private String expiryDate;
    private Patient patient;

    public InsuranceDto(Insurance insurance){
        this.id=insurance.getId();
        this.billAmount=insurance.getBillAmount();
        this.expiryDate=insurance.getExpiryDate();
        this.patient=insurance.getPatient();
    }

}
