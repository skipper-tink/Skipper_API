package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.entities.GradeSkill;
import com.backend.tinkoff_backend.services.GradeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeSkillController {

    @Autowired
    GradeSkillService gradeSkillService;

    @PostMapping("/gradeSkills")
    public ResponseEntity<GradeSkill> createGradeSkill(@RequestBody GradeSkill gradeSkill) {
        gradeSkillService.createGradeSkill(gradeSkill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/gradeSkills/{id}")
    public ResponseEntity<GradeSkill> getGradeSkillById(@PathVariable("id") long gradeSkillId) {
        try {
            return new ResponseEntity<>(gradeSkillService.getGradeSkillById(gradeSkillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/gradeSkills/{gradeId}")
    public ResponseEntity<List<GradeSkill>> getGradeSkillsByGradeId(@PathVariable("gradeId") long gradeId) {
        try {
            return new ResponseEntity<>(gradeSkillService.getGradeSkillsByGradeId(gradeId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gradeSkills/{skillId}")
    public ResponseEntity<List<GradeSkill>> getGradeSkillsBySkillId(@PathVariable("skillId") long skillId) {
        try {
            return new ResponseEntity<>(gradeSkillService.getGradeSkillsBySkillId(skillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/gradeSkills")
    public ResponseEntity<List<GradeSkill>> getAllGradeSkills() {
        try {
            return new ResponseEntity<>(gradeSkillService.getAllGradeSKills(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/gradeSkills/{id}")
    public ResponseEntity<GradeSkill> updateGradeSkill(@PathVariable("id") long gradeSkillId, @RequestBody GradeSkill gradeSkill) {
        try {
            return new ResponseEntity<>(gradeSkillService.updateGradeSkill(gradeSkillId, gradeSkill), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/gradeSkills/{id}")
    public ResponseEntity<GradeSkill> deleteGradeSKill(@PathVariable("id") long gradeSkillId) {
        try {
            gradeSkillService.deleteGradeSKill(gradeSkillId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/gradeSkills")
    public ResponseEntity<GradeSkill> deleteAllGradeSkills() {
        gradeSkillService.deleteAllGradeSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
