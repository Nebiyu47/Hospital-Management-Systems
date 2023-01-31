package com.example.backend.Repository;

import com.example.backend.Entity.Medicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicosRepository extends JpaRepository<Medicos,Long> {
    @Query(value = "select * from #{#entityName} m where m.med_Id=?1",nativeQuery = true)
    public List<Medicos> findByPatientId(Long id);
}
