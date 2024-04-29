package com.backend.tinkoff_backend.repositories.jdbcTemplateRepositories.mappers;

import com.backend.tinkoff_backend.entities.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setName(resultSet.getString("name"));
        employee.setFreeTimePerWeek(resultSet.getLong("free_time_per_week"));
        employee.setFreeTimeUntilDate(resultSet.getDate("free_time_until_date"));
        employee.setSpecialization(resultSet.getString("specialization"));
        employee.setQualification(resultSet.getString("qualification"));
        employee.setEmail(resultSet.getString("email"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        return employee;
    }
}
