package com.ufcg.sigex_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sigex_backend.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
