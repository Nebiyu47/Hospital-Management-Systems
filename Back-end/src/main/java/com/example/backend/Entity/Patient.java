package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
    @Column(name="paid")
    private Long paid;
    @OneToOne
    @JoinColumn(name = "tid")
    private Test test;

}
