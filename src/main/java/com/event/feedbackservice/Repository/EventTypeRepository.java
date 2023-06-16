package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType,Integer> {
}
