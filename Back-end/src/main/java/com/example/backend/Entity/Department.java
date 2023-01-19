package com.example.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEP_Id")
    private Long Id;
    @Column(name="departmentName")
    private String departmentName;

}
