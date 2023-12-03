package com.backend.tinkoff_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @Column(name = "feedbackId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long feedbackId;

    @Column(name = "feedbackRating", nullable = false)
    private int feedbackRating;

    @Column(name ="feedbackComment", nullable = false)
    private String feedbackComment;

    @JoinColumn(name = "DemandEmployee_demandEmployeeId",
            referencedColumnName = "demandEmployeeId",
            nullable = false)
    private long DemandEmployee_demandEmployeeId;

    @Column(name = "feedbackReviewerName", nullable = false)
    private String feedbackReviewerName;

    public Feedback() {
    }

    public Feedback(int feedbackRating,
                    String feedbackComment,
                    long DemandEmployee_demandEmployeeId,
                    String feedbackReviewerName) {
        this.feedbackRating = feedbackRating;
        this.feedbackComment = feedbackComment;
        this.DemandEmployee_demandEmployeeId = DemandEmployee_demandEmployeeId;
        this.feedbackReviewerName = feedbackReviewerName;
    }


    public void setFeedbackId(long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getFeedbackRating() {
        return feedbackRating;
    }

    public void setFeedbackRating(int feedbackRating) {
        this.feedbackRating = feedbackRating;
    }

    public String getFeedbackComment() {
        return feedbackComment;
    }

    public void setFeedbackComment(String feedbackComment) {
        this.feedbackComment = feedbackComment;
    }

    public long getDemandEmployee_demandEmployeeId() {
        return DemandEmployee_demandEmployeeId;
    }

    public void setDemandEmployee_demandEmployeeId(long demandEmployee_demandEmployeeId) {
        DemandEmployee_demandEmployeeId = demandEmployee_demandEmployeeId;
    }

    public String getFeedbackReviewerName() {
        return feedbackReviewerName;
    }

    public void setFeedbackReviewerName(String feedbackReviewerName) {
        this.feedbackReviewerName = feedbackReviewerName;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", feedbackRating=" + feedbackRating +
                ", feedbackComment='" + feedbackComment + '\'' +
                ", DemandEmployee_demandEmployeeId=" + DemandEmployee_demandEmployeeId +
                ", feedbackReviewerName='" + feedbackReviewerName + '\'' +
                '}';
    }
}
