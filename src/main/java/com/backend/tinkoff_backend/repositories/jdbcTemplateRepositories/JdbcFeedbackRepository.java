package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class JdbcFeedbackRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcFeedbackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Feedback> getFeedbacksByEmployeeId(long employeeId) {
        return jdbcTemplate.query("SELECT f.* FROM spr_feedback f " +
                "INNER JOIN spr_demand_employee de ON f.demand_employee_id = de.id " +
                "WHERE de.employee_id = ?;", new Object[]{employeeId}, new int[]{Types.BIGINT}, new FeedbackMapper());
    }
}
