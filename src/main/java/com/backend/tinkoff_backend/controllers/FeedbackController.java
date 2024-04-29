package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
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
    public ResponseEntity<Long> createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new MyRetrievalFailureException("Feedback creating error"));
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable("id") long feedbackId) {
        return feedbackService.getFeedbackById(feedbackId)
                .map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Feedback getting by id error"));
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
        return feedbackService.updateFeedback(feedbackId, feedback)
                .map(f -> new ResponseEntity<>(f, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Feedback updating error"));
    }

    @DeleteMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") long feedbackId) {
        return feedbackService.deleteFeedback(feedbackId)
                .map(f -> new ResponseEntity<>(f, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Feedback deletion error"));
    }

    @DeleteMapping("/feedbacks")
    public ResponseEntity<Feedback> deleteAllFeedbacks() {
        feedbackService.deleteAllFeedbacks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
