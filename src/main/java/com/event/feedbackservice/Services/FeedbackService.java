package com.event.feedbackservice.Services;

import com.event.feedbackservice.Response.ApiResponse;
import com.event.feedbackservice.payload.FeedbackDto;

public interface FeedbackService {
    public ApiResponse<?> createFeedback(FeedbackDto feedbackDto);
    public ApiResponse<?> updateFeedback(FeedbackDto feedbackDto);
    public ApiResponse<?> deleteFeedback(int eventId, int attendeeId);
    public ApiResponse<?> getAllFeedbacks(int eventId);
}
