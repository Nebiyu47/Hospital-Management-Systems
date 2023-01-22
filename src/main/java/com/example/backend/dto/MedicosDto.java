package com.example.backend.dto;

import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Medicos;
import com.example.backend.Entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class MedicosDto {
    private Long id;
    private String medRecorded;
    private Date date;
    private int price;
    private int quantity;
    private Long total;
    private Patient patient;
    private Doctor doctor;

  public MedicosDto(Medicos medicos){
      this.id=medicos.getId();
      this.medRecorded=medicos.getMedRecorded();
      this.date=medicos.getDate();
      this.price=medicos.getPrice();
      this.quantity=medicos.getQuantity();
      this.total=medicos.getTotal();
      this.patient=medicos.getPatient();
      this.doctor=medicos.getDoctor();
  }
}
