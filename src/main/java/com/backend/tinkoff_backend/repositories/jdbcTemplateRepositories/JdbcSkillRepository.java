package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers.SkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class JdbcSkillRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSkillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Skill> getSkillsByDemandId(long demandId) {
        return jdbcTemplate.query("SELECT s.* FROM spr_skill s " +
                "INNER JOIN spr_demand_skill ds ON s.id = ds.skill_id " +
                "WHERE ds.demand_id = ?;", new Object[]{demandId}, new int[]{Types.BIGINT}, new SkillMapper());
    }

    public List<Skill> getSkillsByEmployeeId(long employeeId) {
        return jdbcTemplate.query("SELECT s.* FROM spr_skill s " +
                "INNER JOIN spr_employee_skill es ON s.id = es.skill_id " +
                "WHERE es.employee_id = ?;", new Object[]{employeeId}, new int[]{Types.BIGINT}, new SkillMapper());
    }
}
