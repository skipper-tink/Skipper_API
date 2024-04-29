package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.jpaRepositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public Optional<Long> createFeedback(Feedback feedback) {
        return Optional.of(feedbackRepository.save(new Feedback(feedback)).getId());
    }

    public Optional<Feedback> getFeedbackById(long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    public List<Feedback> getFeedbacksByDemandEmployeeId(long demandEmployeeId) {
        return feedbackRepository.findAllByDemandEmployeeId(demandEmployeeId);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> updateFeedback(long feedbackId, Feedback feedback) {
        return feedbackRepository.findById(feedbackId)
                .filter(f -> f.getDemandEmployeeId() == feedback.getDemandEmployeeId())
                .map(f -> merdgeFeedback(f, feedback))
                .map(f -> feedbackRepository.save(f));
    }

    public Optional<Feedback> deleteFeedback(long feedbackId) {
        return feedbackRepository.findById(feedbackId).stream()
                .peek(p -> feedbackRepository.deleteById(feedbackId))
                .findAny();
    }

    public void deleteAllFeedbacks() {
        feedbackRepository.deleteAll();
    }

    private Feedback merdgeFeedback(Feedback f, Feedback feedback) {
        f.setComment(feedback.getComment());
        f.setRating(feedback.getRating());
        f.setReviewerName(feedback.getReviewerName());
        return f;
    }
}
