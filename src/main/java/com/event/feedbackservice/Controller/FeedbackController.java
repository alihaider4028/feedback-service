package com.event.feedbackservice.Controller;

import com.event.feedbackservice.Services.FeedbackService;
import com.event.feedbackservice.payload.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping()
    public ResponseEntity<?> createFeedback(@RequestBody FeedbackDto feedbackDto){
        return ResponseEntity.ok(this.feedbackService.createFeedback(feedbackDto));
    }
    @GetMapping("/eventId/{eventId}")
    public ResponseEntity<?> getAllFeedbacks(@PathVariable("eventId") int eventId ){

        return ResponseEntity.ok(this.feedbackService.getAllFeedbacks(eventId));
    }
    @DeleteMapping("/eventId/{eventId}/AttendeeId/{AttendeeId}")
    public ResponseEntity<?> deleteFeedback(@PathVariable int eventId, @PathVariable int AttendeeId){
        return ResponseEntity.ok(this.feedbackService.deleteFeedback(eventId,AttendeeId));
    }
    @PatchMapping
    public ResponseEntity<?> updateFeedback(@RequestBody FeedbackDto feedbackDto){
        return ResponseEntity.ok(this.feedbackService.updateFeedback(feedbackDto));
    }
}
