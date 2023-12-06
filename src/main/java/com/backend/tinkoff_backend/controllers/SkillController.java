package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkillBuId(@PathVariable("id") long skillId) {
        try {
            return new ResponseEntity<>(skillService.getSkillById(skillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
