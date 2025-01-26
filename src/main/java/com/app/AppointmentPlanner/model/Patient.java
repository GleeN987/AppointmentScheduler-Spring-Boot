package com.app.AppointmentPlanner.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="patients")
public class Patient {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer patientId;

        @Column(unique = true,nullable = false)
        private String email;
        @Column(nullable = false)
        private String password;
        @Column(nullable = false)
        private String phoneNumber;
        @Column(nullable = false)
        private String firstName;
        @Column(nullable = false)
        private String lastName;
        @Column(nullable = false)
        private Character gender;
        @Column(nullable = false)
        private LocalDate birthDate;
        @Column(nullable = false)
        private String city;


        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
        private List<Appointment> appointments = new ArrayList<>();


        public Integer getPatientId() {
                return patientId;
        }

        public void setPatientId(Integer patientId) {
                this.patientId = patientId;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public Character getGender() {
                return gender;
        }

        public void setGender(Character gender) {
                this.gender = gender;
        }

        public LocalDate getBirthDate() {
                return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
                this.birthDate = birthDate;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public List<Appointment> getAppointments() {
                return appointments;
        }

        public void setAppointments(List<Appointment> appointments) {
                this.appointments = appointments;
        }

}


