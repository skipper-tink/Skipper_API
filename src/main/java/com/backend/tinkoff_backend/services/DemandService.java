package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.repositories.DemandRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandService {

    @Autowired
    DemandRepository demandRepository;

    public void creatDemand(Demand demand) throws ServiceException {
        try {
            demandRepository.save(new Demand(demand.getProjectId(), demand.getDemandTimeConsumption(),
                    demand.getDemandDeadline(), demand.getDemandSpecialization(), demand.getDemandQualification()));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Demand getDemandById(long demandId) throws ServiceException {
        Optional<Demand> demandData = demandRepository.findById(demandId);

        if (demandData.isPresent())
            return demandData.get();
        throw new ServiceException("No such demand");
    }

    public List<Demand> getDemandsByProjectId(long projectId) throws ServiceException {
        List<Demand> demands = demandRepository.findAllByProjectId(projectId);

        if (demands.isEmpty())
            throw new ServiceException("No demands in that project");
        return demands;
    }

    public List<Demand> getAllDemands() throws ServiceException {
        List<Demand> demands = demandRepository.findAll();

        if (demands.isEmpty())
            throw new ServiceException("No demands");
        return demands;
    }

    public Demand updateDemand(long demandId, Demand demand) throws ServiceException {
        Optional<Demand> demandData = demandRepository.findById(demandId);

        if (demandData.isPresent()) {
            Demand _demand = demandData.get();
            _demand.setDemandTimeConsumption(demand.getDemandTimeConsumption());
            _demand.setDemandDeadline(demand.getDemandDeadline());
            _demand.setDemandSpecialization(demand.getDemandSpecialization());
            _demand.setDemandQualification(demand.getDemandQualification());
            return demandRepository.save(_demand);
        }
        throw new ServiceException("No such demand");
    }

    public void deleteDemand(long demandId) throws ServiceException {
        Optional<Demand> demandData = demandRepository.findById(demandId);

        if (demandData.isPresent()) {
            demandRepository.deleteById(demandId);
            return;
        }
        throw new ServiceException("No such demand");
    }

    public void deleteAllDemands() {
        demandRepository.deleteAll();
    }
}
