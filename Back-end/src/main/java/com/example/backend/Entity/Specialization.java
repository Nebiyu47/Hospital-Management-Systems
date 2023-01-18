package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Spec_id")
    private Long id;
    @Column(n)
    private String speciality;
}
