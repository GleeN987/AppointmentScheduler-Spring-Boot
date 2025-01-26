package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctorId", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patientId", nullable = false)
    private Patient patient;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;


    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public @NonNull LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(@NonNull LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

}
