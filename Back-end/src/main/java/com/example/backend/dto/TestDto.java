package com.example.backend.dto;

import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Test;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class TestDto {
    private Long id;
    private String testName;
    private Date testDate;
    private Doctor doctor;

  public TestDto(Test test){
      this.id=test.getId();
      this.testName=test.getTestName();
      this.testDate=test.getTestDate();
      this.doctor=test.getDoctor();
  }
}
