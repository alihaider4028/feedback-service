package com.event.feedbackservice.Services.impl;

import com.event.feedbackservice.Repository.*;
import com.event.feedbackservice.Response.ApiResponse;
import com.event.feedbackservice.Services.FeedbackService;
import com.event.feedbackservice.entity.Attendee;
import com.event.feedbackservice.entity.Event;
import com.event.feedbackservice.entity.Feedback;
import com.event.feedbackservice.entity.FeedbackForm;
import com.event.feedbackservice.exception.resourceException;
import com.event.feedbackservice.payload.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    public EventRepository eventRepository;
    public FeedbackRepository feedbackRepository;
    public AttendeeRepository attendeeRepository;
    public AttendanceRecordRepository attendanceRecordRepository;
    @Autowired
    public FeedbackFormRepository feedbackFormRepository;


    @Autowired
    public FeedbackServiceImpl(EventRepository eventRepository, FeedbackRepository feedbackRepository, AttendeeRepository attendeeRepository, AttendanceRecordRepository attendanceRecordRepository) {
        this.eventRepository = eventRepository;
        this.feedbackRepository = feedbackRepository;
        this.attendeeRepository = attendeeRepository;
        this.attendanceRecordRepository = attendanceRecordRepository;
    }


    @Override
    public ApiResponse<?> createFeedback(FeedbackDto feedback) {
        ApiResponse resp = new ApiResponse<>(HttpStatus.CREATED.value(), "feedback save", feedback);

        if (this.feedbackRepository.findByAttendeeIdAndEventId(feedback.getAttendeeId(), feedback.getEventId()).isEmpty()) {
            Event event = this.eventRepository.findById(feedback.getEventId()).orElseThrow(() -> new resourceException("event", "eventId", feedback.getEventId()));
            Attendee attendee = this.attendeeRepository.findById(feedback.getAttendeeId()).orElseThrow(() -> new resourceException("attendee", "attendeeId", feedback.getAttendeeId()));
            this.attendanceRecordRepository.findByAttendeeIdAndEventId(feedback.getAttendeeId(), feedback.getEventId()).orElseThrow(() -> new resourceException("EventId: " + feedback.getEventId() + ", following event has not bee attended by attendee Id:" + feedback.getAttendeeId(), " response with", feedback.getAttendeeId()));
            Feedback feedbackRep = new Feedback();
            feedbackRep.setAttendeeId(attendee);
            feedbackRep.setEventId(event);
            feedbackRep.setComment(feedback.getComment());
            feedbackRep.setRating(feedback.getRating());
            this.feedbackRepository.save(feedbackRep);
            FeedbackForm feedbackForm = new FeedbackForm();
            feedbackForm.setFeedback(feedbackRep);
            feedbackForm.setAdditionalFeedback(feedback.getAdditionalFeedback());
            feedbackForm.setAttendeeExperience(feedback.getAttendeeExperience());
            feedbackForm.setEventId(event);
            feedbackForm.setDescriptionAccuracy(feedback.getDescriptionAccuracy());
            feedbackForm.setLocationSuitability(feedback.getLocationSuitability());
            feedbackForm.setTechnicalQuality(feedback.getTechnicalQuality());
            this.feedbackFormRepository.save(feedbackForm);
        } else {
            throw new resourceException("feedback has already submitted on event Id: " + feedback.getEventId(), " by Attendee id: " + feedback.getAttendeeId());
        }
        return resp;
    }


    @Override
    public ApiResponse<?> updateFeedback(FeedbackDto feedback) {
        ApiResponse resp = new ApiResponse<>(HttpStatus.CREATED.value(), "feedback updated", feedback);
        Event event = this.eventRepository.findById(feedback.getEventId()).orElseThrow(() -> new resourceException("event", "eventId", feedback.getEventId()));
        Attendee attendee = this.attendeeRepository.findById(feedback.getAttendeeId()).orElseThrow(() -> new resourceException("attendee", "attendeeId", feedback.getAttendeeId()));
        this.attendanceRecordRepository.findByAttendeeIdAndEventId(feedback.getAttendeeId(), feedback.getEventId()).orElseThrow(() -> new resourceException("EventId: " + feedback.getEventId() + ", following event has not bee attended by attendee Id:" + feedback.getAttendeeId(), " response with", feedback.getAttendeeId()));
        Feedback feedbackRep = this.feedbackRepository.findFeedbackByEventIdAndAndAttendeeId(feedback.getAttendeeId(), feedback.getEventId());
        feedbackRep.setComment(feedback.getComment());
        feedbackRep.setRating(feedback.getRating());
        this.feedbackRepository.save(feedbackRep);
        FeedbackForm feedbackForm = this.feedbackFormRepository.findFeedbackByEventIdAndAndAttendeeId(feedback.getAttendeeId(), feedback.getEventId());
        feedbackForm.setAdditionalFeedback(feedback.getAdditionalFeedback());
        feedbackForm.setAttendeeExperience(feedback.getAttendeeExperience());
        feedbackForm.setDescriptionAccuracy(feedback.getDescriptionAccuracy());
        feedbackForm.setLocationSuitability(feedback.getLocationSuitability());
        feedbackForm.setTechnicalQuality(feedback.getTechnicalQuality());
        this.feedbackFormRepository.save(feedbackForm);

        return resp;
    }

    @Override
    public ApiResponse<?> deleteFeedback(int eventId, int AttendeeId) {
       Feedback feedback = this.feedbackRepository.findFeedbackByEventIdAndAndAttendeeId(eventId,AttendeeId);

       ApiResponse resp;
        if (feedback!=null) {
            FeedbackForm feedbackForm = this.feedbackFormRepository.findFeedbackByEventIdAndAndAttendeeId(eventId,AttendeeId);
            this.feedbackFormRepository.delete(feedbackForm);
            this.feedbackRepository.delete(feedback);
            resp = new ApiResponse<>(HttpStatus.CREATED.value(), "feedback found", "feedback deleted");
        } else {
            resp = new ApiResponse<>(HttpStatus.CREATED.value(), "no event found with following eventId:", eventId);
        }
        return resp;
    }

    @Override
    public ApiResponse<?> getAllFeedbacks(int eventId) {
        List<Feedback> list = this.feedbackRepository.findAllByEventId(eventId);
        ApiResponse resp;
        if (!list.isEmpty()) {
            resp = new ApiResponse<>(HttpStatus.CREATED.value(), "feedback found", list);
        } else {
            resp = new ApiResponse<>(HttpStatus.CREATED.value(), "no event found with following eventId:", eventId);
        }
        return resp;
    }
}
