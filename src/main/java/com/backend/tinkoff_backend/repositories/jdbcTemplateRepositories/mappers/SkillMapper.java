package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers;

import com.backend.tinkoff_backend.entities.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillMapper implements RowMapper<Skill> {
    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill s = new Skill();
        s.setId(rs.getLong("id"));
        s.setName(rs.getString("name"));
        s.setSpecialization(rs.getString("specialization"));
        return s;
    }
}
