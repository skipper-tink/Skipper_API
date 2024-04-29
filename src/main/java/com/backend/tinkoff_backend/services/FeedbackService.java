package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.JdbcFeedbackRepository;
import com.backend.tinkoff_backend.repositories.jpaRepositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    JdbcFeedbackRepository jdbcFeedbackRepository;

    public Optional<Long> createFeedback(Feedback feedback) {
        return Optional.of(feedbackRepository.save(new Feedback(feedback)).getId());
    }

    public List<Feedback> getFeedbacksByEmployeeId(long employeeId) {
        return jdbcFeedbackRepository.getFeedbacksByEmployeeId(employeeId);
    }

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Pair<Feedback, Feedback>> updateFeedback(long feedbackId, Feedback feedback) {
        return feedbackRepository.findById(feedbackId)
                .filter(f -> f.getDemandEmployeeId() == feedback.getDemandEmployeeId())
                .map(f -> Pair.of(merdgeFeedback(f, feedback), f))
                .stream()
                .peek(pair -> feedbackRepository.save(pair.getFirst()))
                .findAny();
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
