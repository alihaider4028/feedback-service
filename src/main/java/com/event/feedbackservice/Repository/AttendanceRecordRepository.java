package com.event.feedbackservice.Repository;

import com.event.feedbackservice.entity.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord,Integer> {
    @Query("select a from AttendanceRecord a where a.attendeeId.userId=:attendeeId and a.eventId.eventId=:eventId ")

    public Optional <AttendanceRecord> findByAttendeeIdAndEventId(int attendeeId, int eventId);
}
