package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.services.DemandSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemandSkillController {

    @Autowired
    DemandSkillService demandSkillService;

    @PostMapping("/demandSkills")
    public ResponseEntity<DemandSkill> createDemandSkill(@RequestParam DemandSkill demandSkill) {
        demandSkillService.createDemandSkill(demandSkill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/demandSkill/{id}")
    public ResponseEntity<DemandSkill> getDemandSKillById(@PathVariable("id") long demandSkillId) {
        try {
            return new ResponseEntity<>(demandSkillService.getDemandSkillById(demandSkillId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
