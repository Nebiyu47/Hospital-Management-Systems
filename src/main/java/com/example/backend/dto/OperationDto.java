package com.example.backend.dto;

import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Operation;
import com.example.backend.Entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class OperationDto {

    private Long Id;
    private String operationName;
    private Patient patient;
    private Doctor doctor;


public OperationDto(Operation operation){
    this.Id=operation.getId();
    this.operationName=operation.getOperationName();
    this.patient=operation.getPatient();
    this.doctor=operation.getDoctor();

}}
