package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
