package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ward")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "war_id")
    private Long id;
    @Column(name = "wardName")
    private String wardName;
    @OneToOne
    @JoinColumn(name = "Doc_id")
    private Doctor doctor;
    @OneToOne
    @JoinColumn(name = "pat_id")
    Patient patient;

}
