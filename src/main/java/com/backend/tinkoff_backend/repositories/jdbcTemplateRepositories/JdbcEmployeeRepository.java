package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories;

import com.backend.tinkoff_backend.controllers.search.SearchPojo;
import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<SearchPojo> getAllEmployeesWithSkills() {
        String sql = "SELECT e.*, s.id as skill_id, s.name as skill_name, s.specialization as skill_specialization " +
                "FROM spr_employee e " +
                "LEFT JOIN spr_employee_skill es ON e.id = es.employee_id " +
                "LEFT JOIN spr_skill s ON es.skill_id = s.id";

        return jdbcTemplate.query(sql, (ResultSet rs) -> {
            Map<Long, SearchPojo> searchPojoMap = new HashMap<>();
            int rowNum = 0;
            while (rs.next()) {
                long employeeId = rs.getLong("id");
                SearchPojo searchPojo = searchPojoMap.get(employeeId);
                if (searchPojo == null) {
                    Employee employee = new EmployeeMapper().mapRow(rs, rowNum);

                    searchPojo = new SearchPojo();
                    searchPojo.setEmployee(employee);
                    searchPojo.setSkills(new ArrayList<>());
                    searchPojoMap.put(employeeId, searchPojo);
                }

                long skillId = rs.getLong("skill_id");
                if (skillId != 0) {
                    Skill skill = new Skill();
                    skill.setId(rs.getLong("skill_id"));
                    skill.setName(rs.getString("skill_name"));
                    skill.setSpecialization(rs.getString("skill_specialization"));
                    searchPojo.getSkills().add(skill);
                }
                rowNum++;
            }
            return new ArrayList<>(searchPojoMap.values());
        });
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
