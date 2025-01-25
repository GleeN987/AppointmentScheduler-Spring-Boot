package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Doctor;
import com.app.AppointmentPlanner.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addDoctor(Doctor doctor){
        this.doctorRepository.save(doctor);
    }

    public void removeDoctorById(int id){
        Doctor doctorToDelete = getDoctorById(id);
        doctorRepository.delete(doctorToDelete);
    }

}
