package com.backend.tinkoff_backend.unused.profile;

import com.backend.tinkoff_backend.entities.Employee;
import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.EmployeeService;
import com.backend.tinkoff_backend.services.FeedbackService;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    FeedbackService feedbackService;

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

    @PostMapping("/feedback")
    public ResponseEntity<Long> postFeedback(@RequestBody Feedback feedback) {
        Optional<Long> opt = feedbackService.createFeedback(feedback);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        } throw new MyRetrievalFailureException("Profile feedback posting error");
    }
}

