package com.event.feedbackservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @ManyToOne
    Attendee attendeeId;
    @ManyToOne
    Event eventId;
    int rating;
    String Comment;

}
