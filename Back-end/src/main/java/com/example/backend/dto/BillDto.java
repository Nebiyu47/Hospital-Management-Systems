package com.example.backend.dto;

import com.example.backend.Entity.Bill;
import com.example.backend.Entity.Insurance;
import com.example.backend.Entity.Patient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
public class BillDto {
  private Long id;
    private Date billDate;
    private boolean insuared;
    private Insurance insurance;
    private boolean isInsuared;
    private Patient patient;

    public BillDto(Bill bill){
        this.id=bill.getId();
        this.billDate=bill.getBillDate();
        this.insuared=bill.insuared();
        this.isInsuared=bill.isInsuared();
        this.patient=bill.getPatient();
    }
}
