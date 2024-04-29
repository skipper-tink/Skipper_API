package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.exceptions.MyInvalidArgumentException;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/skills")
    public ResponseEntity<Long> createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new MyInvalidArgumentException("Skill creation error"));
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") long skillId) {
        return skillService.getSkillById(skillId)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Skill getting by id error"));
    }

    @GetMapping("/skills/{specialization}")
    public ResponseEntity<List<Skill>> getSkillsBySpecialization(@PathVariable("specialization") String specialization) {
        return new ResponseEntity<>(skillService.getAllSkillsBySpecialization(specialization), HttpStatus.OK);
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable("id") long skillId, @RequestBody Skill skill) {
        return skillService.updateSkill(skillId, skill)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Skill updating error"));
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable("id") long skillId) {
        return skillService.deleteSkill(skillId)
                .map(s -> new ResponseEntity<>(s, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Skill deletion error"));
    }

    @DeleteMapping("/skills")
    public ResponseEntity<Skill> deleteAllSkills() {
        skillService.deleteAllSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
