package com.projets.Defitech.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.projets.Defitech.Models.Demand;
import com.projets.Defitech.Repository.DemandRepository;
import com.votreentreprise.pidgec.util.MappingUtil;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    public List<DemandDTO> getAllDemands() {
        List<Demand> demands = demandRepository.findAll();
        return MappingUtil.mapList(demands, DemandDTO.class);
    }

    public DemandDTO getDemandById(Long id) {
        Optional<Demand> optionalDemand = demandRepository.findById(id);
        if (optionalDemand.isPresent()) {
            return MappingUtil.map(optionalDemand.get(), DemandDTO.class);
        }
        // Gérer la situation où la demande n'est pas trouvée
        return null;
    }

    public DemandDTO createDemand(DemandDTO demandDTO) {
        Demand demand = MappingUtil.map(demandDTO, Demand.class);
        demand = demandRepository.save(demand);
        return MappingUtil.map(demand, DemandDTO.class);
    }

    // Autres méthodes pour la mise à jour, la suppression, etc.
    
    public DemandDTO updateDemand(Long id, DemandDTO demandDTO) {
        Optional<Demand> optionalDemand = demandRepository.findById(id);
        if (optionalDemand.isPresent()) {
            Demand existingDemand = optionalDemand.get();
            existingDemand.setDescription(demandDTO.getDescription());
            // Mettre à jour d'autres attributs si nécessaire
            existingDemand = demandRepository.save(existingDemand);
            return MappingUtil.map(existingDemand, DemandDTO.class);
        }
        // Gérer la situation où la demande n'est pas trouvée
        return null;
    }

    public void deleteDemand(Long id) {
        demandRepository.deleteById(id);
    }
}

