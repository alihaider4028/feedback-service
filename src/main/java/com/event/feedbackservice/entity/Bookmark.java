package com.event.feedbackservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookmarkId;
    @OneToOne
    private Event event;

}
