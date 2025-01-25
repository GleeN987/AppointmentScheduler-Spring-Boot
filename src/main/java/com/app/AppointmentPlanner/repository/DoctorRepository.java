package com.app.AppointmentPlanner.repository;

import com.app.AppointmentPlanner.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
