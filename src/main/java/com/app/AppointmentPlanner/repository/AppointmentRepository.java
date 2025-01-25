package com.app.AppointmentPlanner.repository;

import com.app.AppointmentPlanner.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
