package com.example.backend.dto;

import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Test;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestDto {
    private Long id;
    private String testName;
    private String testDate;
    private Doctor doctor;

  public TestDto(Test test){
      this.id=test.getId();
      this.testName=test.getTestName();
      this.testDate=test.getTestDate();
      this.doctor=test.getDoctor();
  }
}
