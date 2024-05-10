package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers.DemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class JdbcDemandRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcDemandRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Demand> getDemandsByEmployeeId(long employeeId) {
        return jdbcTemplate.query("SELECT d.* FROM spr_demand d " +
                "INNER JOIN spr_demand_employee de ON d.id = de.demand_id " +
                "WHERE de.employee_id = ?;", new Object[]{employeeId}, new int[]{Types.BIGINT}, new DemandMapper());
    }


    public void deleteAllEmployeesOnDemandId(long demandId) {
        jdbcTemplate.update("DELETE FROM spr_demand_employee WHERE demand_id = ?", demandId);
    }

    public void deleteSkillsOnDemand(long demandId) {
        jdbcTemplate.update("DELETE FROM spr_demand_skill WHERE demand_id = ?", demandId);
    }
}
