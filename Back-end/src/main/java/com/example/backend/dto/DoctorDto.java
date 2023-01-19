package com.example.backend.dto;

import com.example.backend.Entity.Department;
import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Specialization;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String DoctorName;
    private String doctorAddress;
    private Long doctorPhoneNumber;
    private Department department;
    private Specialization specialization;


  public DoctorDto(Doctor doctor){
      this.id=doctor.getId();
      this.DoctorName=doctor.getDoctorName();
      this.doctorAddress=doctor.getDoctorAddress();
      this.doctorPhoneNumber=doctor.getDoctorPhoneNumber();
      this.department=doctor.getDepartment();
      this.specialization=doctor.getSpecialization();
  }


}
