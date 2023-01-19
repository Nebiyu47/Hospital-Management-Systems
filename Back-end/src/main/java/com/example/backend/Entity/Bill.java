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
@Data
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

    public boolean getisInsuared() {
        return isInsuared;
    }

    public void setInsuared(boolean isinsuared) {
        this.isInsuared=isinsuared;
    }
    public boolean getInsuared(){
        return insuared;
    }
    public void setinsuared(boolean insuared){
        this.insuared=insuared;
    }

}
