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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ope_id")
    private Long Id;
    @Column(name = "operationName")
    private String operationName;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pat_id")
    private Patient patient;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Doc_id")
    private Doctor doctor;
}
