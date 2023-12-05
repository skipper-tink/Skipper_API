package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.FeedbackRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public void createFeedback(Feedback feedback) {
        feedbackRepository.save(new Feedback(feedback.getFeedbackRating(), feedback.getFeedbackComment(),
                feedback.getDemandEmployeeId(), feedback.getFeedbackReviewerName()));
    }

    public Feedback getFeedbackById(long feedbackId) throws ServiceException {
        Optional<Feedback> feedbackData = feedbackRepository.findById(feedbackId);

        if (feedbackData.isPresent())
            return feedbackData.get();
        throw new ServiceException("No such feedback");
    }
}
