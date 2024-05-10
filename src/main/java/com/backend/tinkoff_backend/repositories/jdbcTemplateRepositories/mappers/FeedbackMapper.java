package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers;

import com.backend.tinkoff_backend.entities.Feedback;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackMapper implements RowMapper<Feedback> {
    @Override
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setId(rs.getLong("id"));
        feedback.setRating(rs.getInt("rating"));
        feedback.setComment(rs.getString("comment"));
        feedback.setDemandEmployeeId(rs.getLong("demand_employee_id"));
        feedback.setReviewerName(rs.getString("reviewer_name"));
        return feedback;
    }
}
