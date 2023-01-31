package com.example.backend.dto;

import com.example.backend.Entity.Specialization;
import jakarta.persistence.Column;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
public class SpecializationDto {
    private Long id;
    private String speciality;

    public SpecializationDto(Specialization specialization){
        this.id= specialization.getId();
        this.speciality=specialization.getSpeciality();
    }
}
