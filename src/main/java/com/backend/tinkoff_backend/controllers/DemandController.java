package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandController {

    @Autowired
    DemandService demandService;

    @PostMapping("/demands")
    public ResponseEntity<Demand> createDemand(@RequestParam Demand demand) {
        try {
            demandService.creatDemand(demand);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/demands/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") long demandId) {
        try {
            return new ResponseEntity<>(demandService.getDemandById(demandId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demands/{projectId}")
    public ResponseEntity<List<Demand>> getDemandsByProjectId(@PathVariable("projectId") long projectId) {
        try {
            return new ResponseEntity<>(demandService.getDemandsByProjectId(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/demands")
    public ResponseEntity<List<Demand>> getAllDemands() {
        try {
            return new ResponseEntity<>(demandService.getAllDemands(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/demands/{id}")
    public ResponseEntity<Demand> updateDemand(@PathVariable("id") long demandId,
                                               @RequestBody Demand demand) {
        try {
            return new ResponseEntity<>(demandService.updateDemand(demandId, demand), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/demands/{id}")
    public ResponseEntity<Demand> deleteDemand(@PathVariable("id") long demandId) {
        try {
            demandService.deleteDemand(demandId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
