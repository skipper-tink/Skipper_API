package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Skill;
import com.backend.tinkoff_backend.services.DemandSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandSkillController {

    @Autowired
    DemandSkillService demandSkillService;

    @PostMapping("/demand/{demandId}/Skills")
    public ResponseEntity createSkillsOnDemand(@PathVariable("demandId") long demandId, @RequestBody List<Long> skillIds) {
        demandSkillService.createSkillsOnDemand(demandId, skillIds);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/demand/{demandId}/skills")
    public ResponseEntity<List<Skill>> getSkillsByDemandId(@PathVariable("demandId") long demandId) {
        return new ResponseEntity<>(demandSkillService.getSkillsByDemandId(demandId), HttpStatus.OK);
    }

    @PutMapping("/demand/{demandId}/skills")
    public ResponseEntity updateSkillsOnDemand(@PathVariable("demandId") long demandId, @RequestBody List<Long> skillIds) {
        demandSkillService.updateSkillsOnDemand(demandId, skillIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/demand/{demandId}/skills")
    public ResponseEntity deleteSkillsOnDemand(@PathVariable("demandId") long demandId) {
        demandSkillService.deleteSkillsOnDemand(demandId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/demandSkills")
    public ResponseEntity deleteAllDemandSkills() {
        demandSkillService.deleteAllDemandSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
