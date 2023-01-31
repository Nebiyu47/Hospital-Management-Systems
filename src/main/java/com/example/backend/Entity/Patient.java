package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pat_id")
    private Long Id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name = "DateOfBirth")
    private String dateOfBirth;
    @Column(name = "patientAdd")
    private String patientAdded;
    @Column(name="mobileNumber")
    private Long mobileNumber;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tid")
    private Test test;

}
