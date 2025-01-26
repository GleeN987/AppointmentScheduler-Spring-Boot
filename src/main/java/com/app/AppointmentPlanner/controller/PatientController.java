package com.app.AppointmentPlanner.controller;

import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.model.Patient;
import com.app.AppointmentPlanner.repository.PatientRepository;
import com.app.AppointmentPlanner.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class PatientController {

    private final PatientRepository patientRepository;
    private PatientService patientService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public PatientController(PatientService patientService, PatientRepository patientRepository){
        this.patientService = patientService;
        this.patientRepository = patientRepository;
    }


    @GetMapping("/register")
    public String viewPatientRegisterForm(Model model, Authentication authentication){
        if (authentication != null){
            return "register_already_registered";
        }
        else {
            model.addAttribute("patient", new Patient());
            return "register_patient";
        }
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute("patient") Patient patient, RedirectAttributes redirectAttributes){
        Patient patient1 = patientRepository.findByEmail(patient.getEmail());
        if (patient1!=null){
            redirectAttributes.addFlashAttribute("error", "Email already exists. Please use a different email.");
            return "register_patient";
        }
        patient.setPassword(encoder.encode(patient.getPassword()));
        patientService.savePatient(patient);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login_patient";
    }

    @GetMapping("/profile")
    public String showProfile() {
        return "profile";
    }

    @GetMapping("/appointments")
    public String showAppointments(Principal principal, Model model) {
        String loggedInEmail = principal.getName();
        Patient patient = patientService.getPatientByEmail(loggedInEmail);
        List<Appointment> appointments = patient.getAppointments();
        model.addAttribute("appointments", appointments);
        return "appointments";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Patient patient = patientService.getPatientByEmail(email);
        if (patient != null && new BCryptPasswordEncoder().matches(password, patient.getPassword())) {
            session.setAttribute("loggedInPatient", patient);
            return "redirect:/";
        }
        else {
            return "login_patient";
        }
    }

}
