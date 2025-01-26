package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Patient;
import com.app.AppointmentPlanner.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient getPatientByEmail(String email){
        return patientRepository.findByEmail(email);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    private int getPatientIdFromUsername(String username) {
        // Fetch patientId from your service layer or database based on username
        return patientRepository.findByEmail(username).getPatientId();
    }

    public Patient getPatientById(Integer patientId) {
        return patientRepository.getById(patientId);
    }
}
