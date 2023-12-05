package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
