package com.ufcg.sigex_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sigex_backend.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
