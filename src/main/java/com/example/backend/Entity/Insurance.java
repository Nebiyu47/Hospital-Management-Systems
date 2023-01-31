package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insurance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ins_id")
    private Long id;
    @Column(name = "billAmount")
    private double billAmount;
    @Column(name = "expiryDate")
    private String expiryDate;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Patient patient;
}
