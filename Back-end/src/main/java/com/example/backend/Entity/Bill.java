package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Id;
    @Column(name = "billDate")
    @Temporal(TemporalType.DATE)
    private Date billDate;
    @Column(name = "insuared")
    private boolean insuared;
    @OneToOne
    @JoinColumn(name = "ins_id")
    private Insurance insurance;
    @Column(name="isInsurance")
    private boolean isInsuared;
    @OneToOne
    @JoinColumn(name="pat_id")
    private Patient patient;
}
