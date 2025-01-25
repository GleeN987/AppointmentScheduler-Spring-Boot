package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="patients")
@Data
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer patientId;
        private String email;
        private String password;
        private String phoneNumber;
        private String firstName;
        private String lastName;
        private Character gender;
        private LocalDate birthDate;
        private String city;
        private Integer height;
        private Integer weight;

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        private List<Appointment> appointments = new ArrayList<>();

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        private List<Rating> ratings = new ArrayList<>();
}


