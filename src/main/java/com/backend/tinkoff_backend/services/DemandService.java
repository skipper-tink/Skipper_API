package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Demand;
import com.backend.tinkoff_backend.repositories.DemandRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
