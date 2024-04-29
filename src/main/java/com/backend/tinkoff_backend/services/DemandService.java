package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.repositories.jpaRepositories.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandService {

    @Autowired
    DemandRepository demandRepository;

    public Optional<Long> creatDemand(Demand demand) {
        return Optional.of(
                demandRepository.save(new Demand(
                        demand.getProjectId(),
                        demand.getTimeConsumption(),
                        demand.getDeadline(),
                        demand.getSpecialization(),
                        demand.getQualification())).getId()
        );
    }

    public Optional<Demand> getDemandById(long demandId) {
        return demandRepository.findById(demandId);
    }

    public List<Demand> getDemandsByProjectId(long projectId) {
        return demandRepository.findAllByProjectId(projectId);
    }

    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    public Optional<Demand> updateDemand(long demandId, Demand demand) {
        return demandRepository.findById(demandId)
                .map(d -> merdgeDemand(d, demand))
                .map(d -> demandRepository.save(d));
    }

    public Optional<Demand> deleteDemand(long demandId) {
        return demandRepository.findById(demandId).stream()
                .peek(d -> demandRepository.deleteById(demandId))
                .findAny();
    }

    public void deleteAllDemands() {
        demandRepository.deleteAll();
    }

    private Demand merdgeDemand(Demand d, Demand demand) {
        d.setDeadline(demand.getDeadline());
        d.setQualification(demand.getQualification());
        d.setSpecialization(demand.getSpecialization());
        d.setTimeConsumption(demand.getTimeConsumption());
        d.setProjectId(demand.getProjectId());
        return d;
    }
}
