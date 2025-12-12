package com.ufcg.sigex_backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sigex_backend.models.Institute;

public interface InstituteRepository extends JpaRepository<Institute, UUID> {
    
}
