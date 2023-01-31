package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "med_Id")
    private Long med_Id;
    @Column(name = "medRecorded")
    private String medRecorded;
    @Column(name = "date")
    private Date date;
    @Column(name = "price")
    private int price;
    @Column(name="quantity")
    private int quantity;
    @Column(name = "total")
    private Long total;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pat_id")
    private Patient patient;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Doc_id")
    private Doctor doctor;
}
