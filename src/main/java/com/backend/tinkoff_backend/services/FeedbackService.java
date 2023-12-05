package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public void createFeedback(Feedback feedback) {
        feedbackRepository.save(new Feedback(feedback.getFeedbackRating(), feedback.getFeedbackComment(),
                feedback.getDemandEmployeeId(), feedback.getFeedbackReviewerName()));
    }
}
