package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/feedbacks")
    public ResponseEntity<Long> createFeedback(@RequestBody Feedback feedback) {
        Optional<Long> opt = feedbackService.createFeedback(feedback);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        }
        throw new MyRetrievalFailureException("Feedback creating error");
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") long feedbackId) {
        Optional<Feedback> opt = feedbackService.getFeedbackById(feedbackId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("Feedback getting by id error");
    }

    @GetMapping("/feedbacks/{demandEmployeeId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByDemandEmployeeId(@PathVariable("demandEmployeeId") long demandEmployeeId) {
        return new ResponseEntity<>(feedbackService.getFeedbacksByDemandEmployeeId(demandEmployeeId),
                HttpStatus.OK);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
    }

    //Won't work if you try to update demandEmployeeId
    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") long feedbackId, @RequestBody Feedback feedback) {
        Optional<Feedback> opt = feedbackService.updateFeedback(feedbackId, feedback);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("Feedback updating error");
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") long feedbackId) {
        Optional<Feedback> opt = feedbackService.deleteFeedback(feedbackId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("Feedback deletion error");
    }

    @DeleteMapping("/feedbacks")
    public ResponseEntity<Feedback> deleteAllFeedbacks() {
        feedbackService.deleteAllFeedbacks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
