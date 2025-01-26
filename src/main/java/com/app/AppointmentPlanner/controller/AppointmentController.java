package com.app.AppointmentPlanner.controller;


import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.model.Doctor;
import com.app.AppointmentPlanner.model.Patient;
import com.app.AppointmentPlanner.service.AppointmentService;
import com.app.AppointmentPlanner.service.DoctorService;
import com.app.AppointmentPlanner.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class AppointmentController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final PatientService patientService;


    public AppointmentController(DoctorService doctorService, AppointmentService appointmentService, PatientService patientService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.patientService = patientService;

    }


    @GetMapping("/schedule")
    public String viewScheduleAppointmentForm(Model model, int doctorId, Principal principal) {
        Appointment appointment = new Appointment();
        Doctor doctor = doctorService.getDoctorById(doctorId);

        String loggedInEmail = principal.getName();

        Patient patient = patientService.getPatientByEmail(loggedInEmail);



        model.addAttribute("appointment", appointment);  // Send appointment to the form
        model.addAttribute("doctor", doctor);
        model.addAttribute("patient", patient);  // Send patient to the form
        return "schedule_appointment";
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute("appointment") Appointment appointment) {

        Doctor doctor = doctorService.getDoctorById(appointment.getDoctor().getDoctorId());
        Patient patient = patientService.getPatientById(appointment.getPatient().getPatientId());

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointmentService.saveAppointment(appointment);

        return "redirect:/";
    }
}
