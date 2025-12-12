package com.ufcg.sigex_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufcg.sigex_backend.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
}
