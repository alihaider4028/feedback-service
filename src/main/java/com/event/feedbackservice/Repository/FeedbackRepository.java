package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.Attendee;
import com.event.feedbackservice.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT f FROM Feedback f WHERE f.attendeeId.userId = :attendeeId AND f.eventId.eventId = :eventId")
    List<Feedback> findByAttendeeIdAndEventId(int attendeeId, int eventId);

    @Query("SELECT f FROM Feedback f WHERE f.eventId.eventId = :eventId")
    List<Feedback> findAllByEventId(int eventId);

    @Query("SELECT f FROM Feedback f WHERE f.attendeeId.userId = :attendeeId AND f.eventId.eventId = :eventId")
    Feedback findFeedbackByEventIdAndAndAttendeeId(int attendeeId, int eventId);

}
