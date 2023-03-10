package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.dialect.function.LpadRpadPadEmulation;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Doc_id")
    private Long id;
    @Column(name = "doctorName")
    private String DoctorName;
    @Column(name = "doctorAddress")
    private String doctorAddress;
    @Column(name = "doctorPhoneNo")
    private Long doctorPhoneNumber;
    @OneToOne
    @JoinColumn(name = "DEP_Id")
    private Department department;
    @OneToOne
    @JoinColumn(name = "Spec_id")
    private Specialization specialization;

}
