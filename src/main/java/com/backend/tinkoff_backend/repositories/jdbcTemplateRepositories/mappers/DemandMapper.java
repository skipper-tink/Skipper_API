package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers;

import com.backend.tinkoff_backend.entities.Demand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemandMapper implements RowMapper<Demand> {

    @Override
    public Demand mapRow(ResultSet resultSet, int i) throws SQLException {
        Demand demand = new Demand();
        demand.setId(resultSet.getInt("id"));
        demand.setProjectId(resultSet.getInt("project_id"));
        demand.setTimeConsumption(resultSet.getInt("time_consumption"));
        demand.setDeadline(resultSet.getDate("deadline"));
        demand.setSpecialization(resultSet.getString("specialization"));
        demand.setQualification(resultSet.getString("qualification"));
        return demand;
    }
}
