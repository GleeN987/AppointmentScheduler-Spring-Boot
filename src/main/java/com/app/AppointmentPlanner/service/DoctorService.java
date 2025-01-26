package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.model.Doctor;
import com.app.AppointmentPlanner.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id){
        return doctorRepository.getById(id);
    }

    public Map<String, Set<String>> doctorAppointments(Doctor doctor){
        List<Appointment> appointments= doctor.getAppointments();
        Map<String, Set<String>> appointmentsMap = new HashMap<>();
        for (Appointment appointment : appointments){
            String date = appointment.getAppointmentDate().toString();
            String time = appointment.getAppointmentTime().toString();
            if (!appointmentsMap.containsKey(date)){
                appointmentsMap.put(date, new HashSet<>());
            }
            appointmentsMap.get(date).add(time);
        }
        return appointmentsMap;
    }

    public void addDoctor(Doctor doctor){
        this.doctorRepository.save(doctor);
    }

    public void removeDoctorById(int id){
        Doctor doctorToDelete = getDoctorById(id);
        doctorRepository.delete(doctorToDelete);
    }

}
