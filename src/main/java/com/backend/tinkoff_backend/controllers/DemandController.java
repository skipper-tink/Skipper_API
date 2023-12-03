package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
