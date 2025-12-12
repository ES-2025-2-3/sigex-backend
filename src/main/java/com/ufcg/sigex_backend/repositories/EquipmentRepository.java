package com.ufcg.sigex_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sigex_backend.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    
}
