package com.app.AppointmentPlanner.controller;

import com.app.AppointmentPlanner.model.Appointment;
import com.app.AppointmentPlanner.model.Doctor;
import com.app.AppointmentPlanner.model.Patient;
import com.app.AppointmentPlanner.service.AppointmentService;
import com.app.AppointmentPlanner.service.DoctorService;
import com.app.AppointmentPlanner.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public String viewScheduleAppointmentForm(Model model, @RequestParam("doctorId") int doctorId, Principal principal) {

        Appointment appointment = new Appointment();

        Doctor doctor = doctorService.getDoctorById(doctorId);

        String loggedInEmail = principal.getName();

        Patient patient = patientService.getPatientByEmail(loggedInEmail);


        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        model.addAttribute("appointment", appointment);
        model.addAttribute("doctor", doctor);
        model.addAttribute("patient", patient);
        return "schedule_appointment";
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
        Doctor doctor = doctorService.getDoctorById(appointment.getDoctor().getDoctorId());
        Patient patient = patientService.getPatientById(appointment.getPatient().getPatientId());

        Map<String, Set<String>> doctorAppointments = doctorService.doctorAppointments(doctor);
        if (doctorAppointments.get(appointment.getAppointmentDate().toString()) != null && doctorAppointments.get(appointment.getAppointmentDate().toString()).contains(appointment.getAppointmentTime().toString())) {

            model.addAttribute("errorMessage", "This appointment date and time is already booked.");
            model.addAttribute("doctor", doctor);
            model.addAttribute("patient", patient);
            return "schedule_appointment";
        }

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointmentService.saveAppointment(appointment);

        return "redirect:/";
    }

}
