package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
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
    public ResponseEntity<Skill> createSkill(@RequestParam Skill skill) {
        skillService.createSkill(skill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") long skillId) {
        try {
            return new ResponseEntity<>(skillService.getSkillById(skillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        try {
            return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable("id") long skillId, @RequestBody Skill skill) {
        try {
            return new ResponseEntity<>(skillService.updateSkill(skillId, skill), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable("id") long skillId) {
        try {
            skillService.deleteSkill(skillId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/skills")
    public ResponseEntity<Skill> deleteAllSkills() {
        skillService.deleteAllSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
