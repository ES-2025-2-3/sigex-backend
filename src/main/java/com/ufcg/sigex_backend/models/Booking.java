package com.ufcg.sigex_backend.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ufcg.sigex_backend.enums.BookingStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    @Setter
    private LocalDate date;

    @Column(nullable = false)
    @Setter
    private LocalDateTime startTime;

    @Column(nullable = false)
    @Setter
    private LocalDateTime endTime;

    @Column(nullable = false)
    @Setter // a ideia é usar o pattern State dps
    private BookingStatus status;
    
    @ManyToOne
    @JoinColumn(name = "booker_id", nullable = false)
    @Setter
    private User booker;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;

    @ManyToMany
    @JoinTable(
        name = "booking_room",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private List<Room> rooms;

    @OneToOne
    @JoinColumn(name = "event_id", nullable = false)
    @Setter
    private Event event;

    public Booking(
        LocalDate date, 
        LocalDateTime startTime, 
        LocalDateTime endTime,
        BookingStatus status, 
        User booker, 
        Institute institute, 
        Event event
    ) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.booker = booker;
        this.institute = institute;
        this.rooms = new ArrayList<>();
        this.event = event;
    }
    
}
