package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.EmployeeService;
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
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/feedbacks")
    public ResponseEntity<Long> createFeedback(@RequestBody Feedback feedback) {
        return Optional.of(
                feedbackService.createFeedback(feedback)
                        .stream()
                        .peek(id -> employeeService.updateEmployeeFeedback(feedback))
                        .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                        .findAny()
        ).get().orElseThrow(() -> new MyRetrievalFailureException("Feedback getting by id error"));
    }

    @GetMapping("/feedbacks/{employeeId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByEmployeeId(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<>(feedbackService.getFeedbacksByEmployeeId(employeeId), HttpStatus.OK);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") long feedbackId, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedbackId, feedback)
                .map(pair -> {
                    employeeService.updateEmployeeOldFeedback(pair.getFirst(),
                            pair.getSecond().getRating());
                    return pair.getFirst();
                })
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
    public ResponseEntity deleteAllFeedbacks() {
        feedbackService.deleteAllFeedbacks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
