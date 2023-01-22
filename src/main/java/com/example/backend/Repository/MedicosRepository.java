package com.example.backend.Repository;

import com.example.backend.Entity.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicosRepository extends JpaRepository<Medicos,Long> {
}
