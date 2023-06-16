package com.event.feedbackservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
@ManyToMany
    List<Bookmark> bookmarks;
@OneToMany
List<AttendanceRecord> attendanceRecords;

}
