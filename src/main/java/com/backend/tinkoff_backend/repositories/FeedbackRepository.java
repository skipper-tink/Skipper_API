package com.backend.tinkoff_backend.repositories;

import com.backend.tinkoff_backend.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
