package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee,Integer> {
}
