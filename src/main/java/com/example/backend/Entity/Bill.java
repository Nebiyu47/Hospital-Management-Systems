package com.example.backend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

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
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private Date billDate;
    @Column(name = "billAmount")
    private double billAmount;
    @Column(name = "insuared")
    private boolean insuared;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ins_id")
    private Insurance insurance;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="pat_id")
    private Patient patient;
    public boolean getInsuared(){
        return insuared;
    }
    public void setinsuared(boolean insuared){
        this.insuared=insuared;
    }

}
