package com.app.AppointmentPlanner.controller;


import com.app.AppointmentPlanner.model.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @GetMapping("/schedule")
    public String viewScheduleAppointmentForm(Model model){
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "schedule_appointment";
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute("appointment") Appointment appointment){

    }
}
