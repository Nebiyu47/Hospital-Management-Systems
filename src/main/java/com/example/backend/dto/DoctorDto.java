package com.example.backend.dto;

import com.example.backend.Entity.Department;
import com.example.backend.Entity.Doctor;
import com.example.backend.Entity.Specialization;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
public class DoctorDto {
    private Long id;
    private String doctorName;
    private String doctorAddress;
    private Long doctorPhoneNumber;
    private Department department;
    private Specialization specialization;


  public DoctorDto(Doctor doctor){
      this.id=doctor.getId();
      this.doctorName=doctor.getDoctorName();
      this.doctorAddress=doctor.getDoctorAddress();
      this.doctorPhoneNumber=doctor.getDoctorPhoneNumber();
      this.department=doctor.getDepartment();
      this.specialization=doctor.getSpecialization();
  }


}
