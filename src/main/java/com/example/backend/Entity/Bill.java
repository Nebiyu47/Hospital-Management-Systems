package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

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
    @Column(name = "billDate")
    private double billAmount;
    @Column(name = "insuared")
    private boolean insuared;
    @OneToOne
    @JoinColumn(name = "ins_id")
    private Insurance insurance;

    @OneToOne
    @JoinColumn(name="pat_id")
    private Patient patient;


    public boolean getInsuared(){
        return insuared;
    }
    public void setinsuared(boolean insuared){
        this.insuared=insuared;
    }



}
