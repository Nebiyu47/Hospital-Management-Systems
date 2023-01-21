package com.example.backend.Repository;

import com.example.backend.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
