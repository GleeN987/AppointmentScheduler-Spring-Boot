package com.app.AppointmentPlanner.repository;

import com.app.AppointmentPlanner.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
