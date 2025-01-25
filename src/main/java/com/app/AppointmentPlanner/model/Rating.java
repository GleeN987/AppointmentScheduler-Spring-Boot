package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="ratings")
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;

    @ManyToOne
    @JoinColumn(name="doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patientId", nullable = false)
    private Patient patient;
    private Long rating;
    private String review;
    private LocalDateTime createdAt = LocalDateTime.now();
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }


}
