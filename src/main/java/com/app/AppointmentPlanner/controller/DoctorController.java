package com.app.AppointmentPlanner.controller;

import com.app.AppointmentPlanner.model.Doctor;
import com.app.AppointmentPlanner.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/doctors")
    public String getAllDoctors(Model model){
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors";

    }

    @GetMapping("/doctors/{id}")
    public String getDoctorById(@PathVariable int id, Model model){
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "doctor_details";
    }


    @GetMapping("/doctors/add")
    public String viewAddDoctorForm(Model model){
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "add_doctor";
    }

    @PostMapping("/doctors/add")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctorService.addDoctor(doctor);
        return "redirect:/";
    }

    @DeleteMapping("/remove/{id}")
    public void deleteDoctorById(@PathVariable int id){
        doctorService.removeDoctorById(id);
    }

}
