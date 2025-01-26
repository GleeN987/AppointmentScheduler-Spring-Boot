package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public Map<String, Set<String>> getExistingAppointments(){
        Map<String, Set<String>> existingAppointments = new HashMap<>();
        for (Appointment appointment : appointmentRepository.findAll()){
            String key = appointment.getAppointmentDate().toString();
            String value = appointment.getAppointmentTime().toString();
            if (!existingAppointments.containsKey(key)){
                existingAppointments.put(key, new HashSet<>());
            }
            existingAppointments.get(key).add(value);
        }

        return existingAppointments;
    }


}
