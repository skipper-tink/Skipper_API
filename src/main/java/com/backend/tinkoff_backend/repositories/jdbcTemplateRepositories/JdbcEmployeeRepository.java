package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class JdbcEmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getEmployeesByDemandId(long demandId) {
        return jdbcTemplate.query("SELECT e.* FROM spr_employee e " +
                "INNER JOIN spr_demand_employee de ON e.id = de.employee_id " +
                "WHERE de.demand_id = ?", new Object[]{demandId}, new int[]{Types.BIGINT}, new EmployeeMapper());
    }
    public void updateEmployeeFeedback(Feedback feedback) {
        jdbcTemplate.update("UPDATE spr_employee e " +
                "JOIN spr_demand_employee de ON e.id = de.employee_id " +
                "SET e.rating = (e.rating * e.feedbacks_count + ?) / (e.feedbacks_count + 1), " +
                "e.feedbacks_count = e.feedbacks_count + 1 " +
                "WHERE e.id = ?;", feedback.getRating(), feedback.getDemandEmployeeId());
    }
    public void updateEmployeeOldFeedback(Feedback newFeedback, double oldRating) {
        jdbcTemplate.update("UPDATE spr_employee e " +
                "JOIN spr_demand_employee de ON e.id = de.employee_id " +
                "SET e.rating = (e.rating * e.feedbacks_count - ? + ?) / (e.feedbacks_count) " +
                "WHERE e.id = ?;", oldRating, newFeedback.getRating(), newFeedback.getDemandEmployeeId());
    }

    public void deleteSkillsByEmployeeId(long employeeId) {
        jdbcTemplate.update("DELETE FROM spr_employee_skill WHERE employee_id = ?", employeeId);
    }
}
