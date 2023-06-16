package com.event.feedbackservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class FeedbackForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int feedbackFormId;
    String additionalFeedback;
    int attendeeExperience;
    int descriptionAccuracy;
    @OneToOne
    Event eventId;
    @OneToOne
    Feedback feedback;
    int locationSuitability;
    int technicalQuality;

}
