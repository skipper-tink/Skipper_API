package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.DemandSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DemandSkillController {

    @Autowired
    DemandSkillService demandSkillService;

    @PostMapping("/demandSkills")
    public ResponseEntity<Long> createDemandSkill(@RequestBody DemandSkill demandSkill) {
        Optional<Long> opt = demandSkillService.createDemandSkill(demandSkill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        }
        throw new MyRetrievalFailureException("DemandSkill creation error");
    }

    @GetMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> getDemandSkillById(@PathVariable("id") long demandSkillId) {
        Optional<DemandSkill> opt = demandSkillService.getDemandSkillById(demandSkillId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("DemandSkill getting by id error");
    }

    @GetMapping("/demandSkills/{demandId}")
    public ResponseEntity<List<DemandSkill>> getDemandSkillsByDemandId(@PathVariable("demandId") long demandId) {
        return new ResponseEntity<>(demandSkillService.getDemandSkillsByDemandId(demandId), HttpStatus.OK);
    }

    @GetMapping("/demandSkills/{skillId}")
    public ResponseEntity<List<DemandSkill>> getDemandSkillsBySkillId(@PathVariable("skillId") long skillId) {
        return new ResponseEntity<>(demandSkillService.getDemandSkillsBySkillId(skillId), HttpStatus.OK);
    }

    @GetMapping("/demandSkills")
    public ResponseEntity<List<DemandSkill>> getAllDemandSkills() {
        return new ResponseEntity<>(demandSkillService.getAllDemandSKills(), HttpStatus.OK);
    }

    @PutMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> updateDemandSkill(@PathVariable("id") long demandSkillId, @RequestBody DemandSkill demandSkill) {
        Optional<DemandSkill> opt = demandSkillService.updateDemandSkill(demandSkillId, demandSkill);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("DemandSkill updating error");
    }

    @DeleteMapping("/demandSkills/{id}")
    public ResponseEntity<DemandSkill> deleteDemandSKill(@PathVariable("id") long demandSkillId) {
        Optional<DemandSkill> opt = demandSkillService.deleteDemandSKill(demandSkillId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("DemandSkill deletion error");
    }

    @DeleteMapping("/demandSkills")
    public ResponseEntity<DemandSkill> deleteAllDemandSkills() {
        demandSkillService.deleteAllDemandSkills();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
