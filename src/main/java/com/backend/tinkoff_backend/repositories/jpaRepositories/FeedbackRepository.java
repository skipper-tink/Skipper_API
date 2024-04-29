package com.backend.tinkoff_backend.repositories.jpaRepositories;

import com.backend.tinkoff_backend.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByDemandEmployeeId(long demandEmployeeId);
}
