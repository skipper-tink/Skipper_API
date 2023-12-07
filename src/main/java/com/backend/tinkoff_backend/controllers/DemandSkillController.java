package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.DemandSkill;
import com.backend.tinkoff_backend.services.DemandSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
