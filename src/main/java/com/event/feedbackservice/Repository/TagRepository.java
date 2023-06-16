package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {
}
