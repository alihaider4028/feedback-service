package com.event.feedbackservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class AttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;
    @ManyToOne
    Attendee attendeeId;
    @ManyToOne
    Event eventId;
}
