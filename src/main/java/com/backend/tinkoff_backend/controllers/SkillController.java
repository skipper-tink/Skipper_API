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
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillService skillService;

    @PostMapping("/skills")
    public ResponseEntity<Long> createSkill(@RequestBody Skill skill) {
        Optional<Long> opt = skillService.createSkill(skill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        } throw new MyInvalidArgumentException("Creation skill error");
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("id") long skillId) {
        Optional<Skill> opt = skillService.getSkillById(skillId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("Getting skill by id error");
    }

    @GetMapping("/skills")
    public ResponseEntity<List<Skill>> getAllSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
    }

    @PutMapping("/skills/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable("id") long skillId, @RequestBody Skill skill) {
        Optional<Skill> opt = skillService.updateSkill(skillId, skill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("Updating skill error");
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable("id") long skillId) {
        Optional<Skill> opt = skillService.deleteSkill(skillId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("Deletion skill error");
    }

    @DeleteMapping("/skills")
    public ResponseEntity<Skill> deleteAllSkills() {
        skillService.deleteAllSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
