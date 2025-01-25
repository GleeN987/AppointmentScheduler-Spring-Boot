package com.app.AppointmentPlanner.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="doctors")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String speciality;
    @NonNull
    private String description;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    public Doctor() {

    }
}
