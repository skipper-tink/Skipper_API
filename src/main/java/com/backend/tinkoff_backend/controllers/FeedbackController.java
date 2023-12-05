package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/feedbacks/{demandEmployeeId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByDemandEmployeeId(@PathVariable("demandEmployeeId") long demandEmployeeId) {
        try {
            return new ResponseEntity<>(feedbackService.getFeedbacksByDemandEmployeeId(demandEmployeeId),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        try {
            return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") long feedbackId, @RequestBody Feedback feedback) {
        try {
            return new ResponseEntity<>(feedbackService.updateFeedback(feedbackId, feedback), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") long feedbackId) {
        try {
            feedbackService.deleteFeedback(feedbackId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/feedbacks")
    public ResponseEntity<Feedback> deleteAllFeedbacks() {
        feedbackService.deleteAllFeedbacks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
