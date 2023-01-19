package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "mobileNo")
    private Long mobileNumber;
    @Column(name="employeeName")
    private String employeeName;
    @Column(name = "employeeAddress")
    private String employeeAddress;
    @OneToOne
    @JoinColumn(name = "DEP_Id")
    private Department department;
}
