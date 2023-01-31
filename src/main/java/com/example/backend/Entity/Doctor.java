package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.dialect.function.LpadRpadPadEmulation;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Doc_id")
    private Long id;
    @Column(name ="doctorName")
    private String doctorName;
    @Column(name = "doctorAddress")
    private String doctorAddress;
    @Column(name = "doctorPhoneNo")
    private Long doctorPhoneNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEP_Id")
    private Department department;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Spec_id")
    private Specialization specialization;

}
