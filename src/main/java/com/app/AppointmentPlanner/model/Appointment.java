package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name="appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @ManyToOne
    @JoinColumn(name="doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patientId", nullable = false)
    private Patient patient;
    @NonNull
    private LocalDateTime appointmentDate;
    private LocalDateTime appointmentTime;
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

    public Appointment() {

    }

}
