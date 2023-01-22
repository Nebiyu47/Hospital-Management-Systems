package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "test_name")
    private String testName;
    @Column (name="testDate")
    @Temporal(TemporalType.DATE)
    private Date testDate;
    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


}
