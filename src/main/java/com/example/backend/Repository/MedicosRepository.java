package com.example.backend.Repository;

import com.example.backend.Entity.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicosRepository extends JpaRepository<Medicos,Long> {

    public List<Medicos> findByPatientId(Long id);
}
