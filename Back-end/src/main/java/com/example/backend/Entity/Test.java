package com.example.backend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "test_name")
    private String testName;
    @Column (name="testDate")
    @Temporal(TemporalType.DATE)
    private Date testDate;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


}
