package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.entities.pojo.ProfilePojo;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.EmployeeService;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    SkillService skillService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<ProfilePojo> getProfile(@PathVariable("employeeId") long employeeId) {
        Optional<Employee> employeeData = employeeService.getEmployeeById(employeeId);

        //Заглушка!!!!
        Optional<List<Skill>> skillsData = Optional.of(
                new ArrayList<>() {{
                    add(new Skill("java", "backend"));
                    add(new Skill("spring", "backend"));
                    add(new Skill("sql", "backend"));
                }}
        );

        if (employeeData.isPresent() && skillsData.isPresent()) {
            return new ResponseEntity<>(new ProfilePojo(skillsData.get(), employeeData.get()), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("Employee or skills is empty in getProfile method");
    }
}

