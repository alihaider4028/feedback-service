package com.event.feedbackservice.payload;

import com.event.feedbackservice.entity.Attendee;
import com.event.feedbackservice.entity.Event;
import com.event.feedbackservice.entity.Feedback;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FeedbackDto {



    int attendeeId;
    int eventId;
    int rating;
    String Comment;
    String additionalFeedback;
    int attendeeExperience;
    int descriptionAccuracy;
    int locationSuitability;
    int technicalQuality;



}
