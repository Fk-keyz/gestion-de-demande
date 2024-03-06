package com.projets.Defitech.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projets.Defitech.Models.Incident;
import com.projets.Defitech.Repository.IncidentRepository;
import com.votreentreprise.pidgec.util.MappingUtil;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<IncidentDTO> getAllIncidents() {
        List<Incident> incidents = incidentRepository.findAll();
        return MappingUtil.mapList(incidents, IncidentDTO.class);
    }

    public IncidentDTO getIncidentById(Long id) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        if (optionalIncident.isPresent()) {
            return MappingUtil.map(optionalIncident.get(), IncidentDTO.class);
        }
        // Gérer la situation où l'incident n'est pas trouvé
        return null;
    }

    public IncidentDTO createIncident(IncidentDTO incidentDTO) {
        Incident incident = MappingUtil.map(incidentDTO, Incident.class);
        incident = incidentRepository.save(incident);
        return MappingUtil.map(incident, IncidentDTO.class);
    }

    // Autres méthodes pour la mise à jour, la suppression, etc.
    
    public IncidentDTO updateIncident(Long id, IncidentDTO incidentDTO) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);
        if (optionalIncident.isPresent()) {
            Incident existingIncident = optionalIncident.get();
            existingIncident.setType(incidentDTO.getType());
            // Mettre à jour d'autres attributs si nécessaire
            existingIncident = incidentRepository.save(existingIncident);
            return MappingUtil.map(existingIncident, IncidentDTO.class);
        }
        // Gérer la situation où l'incident n'est pas trouvé
        return null;
    }

    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}
