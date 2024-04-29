package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
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
    public ResponseEntity<Long> createDemand(@RequestBody Demand demand) {
        return demandService.creatDemand(demand)
                .map(d -> new ResponseEntity<>(d, HttpStatus.CREATED))
                .orElseThrow(() -> new MyRetrievalFailureException("Demand creation error"));
    }

    @GetMapping("/demands/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") long demandId) {
        return demandService.getDemandById(demandId)
                .map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Demand getting by id error"));
    }

    @GetMapping("/demands/{projectId}")
    public ResponseEntity<List<Demand>> getDemandsByProjectId(@PathVariable("projectId") long projectId) {
        return new ResponseEntity<>(demandService.getDemandsByProjectId(projectId), HttpStatus.OK);
    }

    @GetMapping("/demands")
    public ResponseEntity<List<Demand>> getAllDemands() {
        return new ResponseEntity<>(demandService.getAllDemands(), HttpStatus.OK);
    }

    @PutMapping("/demands/{id}")
    public ResponseEntity<Demand> updateDemand(@PathVariable("id") long demandId,
                                               @RequestBody Demand demand) {
        return demandService.updateDemand(demandId, demand)
                .map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Demand updating error"));
    }

    @DeleteMapping("/demands/{id}")
    public ResponseEntity<Demand> deleteDemand(@PathVariable("id") long demandId) {
        return demandService.deleteDemand(demandId)
                .map(d -> new ResponseEntity<>(d, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Demand deletion error"));
    }

    @DeleteMapping("/demands")
    public ResponseEntity deleteAllDemands() {
        demandService.deleteAllDemands();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
