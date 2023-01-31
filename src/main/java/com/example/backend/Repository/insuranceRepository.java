package com.example.backend.Repository;

import com.example.backend.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface insuranceRepository extends JpaRepository<Insurance,Long> {
    @Query(value = "select * from #{#entityName} e where e.ins_id=?1",nativeQuery = true )
    public Insurance getById(Long id);
}
