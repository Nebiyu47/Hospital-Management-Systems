package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ope_id")
    private Long Id;
    @Column(name = "operationName")
    private String operationName;
    @OneToOne
    @JoinColumn(name = "pat_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "Doc_id")
    private Doctor doctor;
}
