package com.app.AppointmentPlanner.repository;

import com.app.AppointmentPlanner.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
