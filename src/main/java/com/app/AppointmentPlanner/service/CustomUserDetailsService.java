package com.app.AppointmentPlanner.service;

import com.app.AppointmentPlanner.model.Patient;
import com.app.AppointmentPlanner.model.UserPrincipal;
import com.app.AppointmentPlanner.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Patient patient = patientRepository.findByEmail(email);

        if (patient==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(patient);
    }

}
