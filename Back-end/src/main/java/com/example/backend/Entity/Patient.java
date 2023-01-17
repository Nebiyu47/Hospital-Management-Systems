package com.example.backend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name="Health_insurance_number")
    private String HealthInsuranceNumber;
    @Column(name = "Birth_date")
    private Date birth_date;
    @Column(name="sex")
    private String sex;
    @Column(name = "address")
    private String address;

}
