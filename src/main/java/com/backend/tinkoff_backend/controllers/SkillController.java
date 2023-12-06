package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/skills")
    public ResponseEntity<Skill> createSkill(@RequestParam Skill skill) {
        skillService.createSkill(skill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
