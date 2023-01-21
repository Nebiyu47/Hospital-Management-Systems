package com.example.backend.Repository;

import com.example.backend.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface insuranceRepository extends JpaRepository<Insurance,Long> {
}
