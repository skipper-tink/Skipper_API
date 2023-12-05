package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/feedbacks")
    public ResponseEntity<Feedback> createFeedback(@RequestParam Feedback feedback) {
        feedbackService.createFeedback(feedback);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") long feedbackId) {
        try {
            return new ResponseEntity<>(feedbackService.getFeedbackById(feedbackId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}