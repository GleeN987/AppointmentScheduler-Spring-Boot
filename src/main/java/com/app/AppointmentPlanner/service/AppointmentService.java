package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }


}
