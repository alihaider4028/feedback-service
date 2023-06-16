package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
}
