package com.ufcg.sigex_backend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String acronym;

    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    @ManyToOne // não sei se deveria permitir que um usuário possa ser responsável por mais de uma istituição, mas tá aí
    @JoinColumn(name = "manager_id", nullable = false)
    private User manager;

    private String contactPhone;

    @ManyToMany
    @JoinTable(
        name = "institute_equipment",
        joinColumns = @JoinColumn(name = "institute_id"),
        inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments;

    public Institute(
        String name, 
        String acronym, 
        User manager, 
        String contactPhone
    ) {
        this.name = name;
        this.acronym = acronym;
        this.manager = manager;
        this.contactPhone = contactPhone;
        this.rooms = new ArrayList<>();
        this.equipments = new ArrayList<>();
    }

    public boolean addRoom(Room room) {
        room.setInstitute(this);
        return this.rooms.add(room);
    }

    public boolean removeRoom(Room room) {
        room.setInstitute(null);
        return this.rooms.remove(room);
    }
}
