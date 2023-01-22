package com.example.backend.dto;

import com.example.backend.Entity.Patient;
import com.example.backend.Entity.Test;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class PatientDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String patientAdded;
    private Long mobileNumber;
    private Long paid;
    private Test test;

    public PatientDto(Patient patient){
        this.Id=patient.getId();
        this.firstName=patient.getFirstName();
        this.lastName=patient.getLastName();
        this.dateOfBirth=patient.getDateOfBirth();
        this.patientAdded=patient.getPatientAdded();
        this.mobileNumber=patient.getMobileNumber();
        this.paid=patient.getPaid();
        this.test=patient.getTest();
    }

}
