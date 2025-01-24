package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name="doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patientId", nullable = false)
    private Patient patient;

    private LocalDateTime appointmentDate;
    private String diagnosis;
    private LocalDateTime createdAt = LocalDateTime.now();
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELLED
    }
}
