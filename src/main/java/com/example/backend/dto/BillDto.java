package com.example.backend.dto;

import com.example.backend.Entity.Bill;
import com.example.backend.Entity.Insurance;
import com.example.backend.Entity.Patient;
import lombok.Data;


import java.util.Date;
@Data
public class BillDto {
  private Long id;
    private Date billDate;
    private double billAmount;
    private boolean insuared;
    private Insurance insurance;
    private boolean isInsuared;
    private Patient patient;

    public BillDto(Bill bill){
        this.id=bill.getId();
        this.billDate=bill.getBillDate();
        this.billAmount=bill.getBillAmount();
        this.insuared=bill.getInsuared();
        this.isInsuared=bill.getisInsuared();
        this.patient=bill.getPatient();
    }
}
