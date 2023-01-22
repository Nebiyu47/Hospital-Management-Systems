package com.example.backend.Repository;

import com.example.backend.Entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward,Long> {
}
