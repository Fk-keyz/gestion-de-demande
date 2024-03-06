package com.projets.Defitech.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projets.Defitech.Service.IncidentDTO;
import com.projets.Defitech.Service.IncidentService;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public ResponseEntity<List<IncidentDTO>> getAllIncidents() {
        List<IncidentDTO> incidents = incidentService.getAllIncidents();
        return new ResponseEntity<>(incidents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentDTO> getIncidentById(@PathVariable Long id) {
        IncidentDTO incident = incidentService.getIncidentById(id);
        if (incident != null) {
            return new ResponseEntity<>(incident, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<IncidentDTO> createIncident(@RequestBody IncidentDTO incidentDTO) {
        IncidentDTO createdIncident = incidentService.createIncident(incidentDTO);
        return new ResponseEntity<>(createdIncident, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidentDTO> updateIncident(@PathVariable Long id, @RequestBody IncidentDTO incidentDTO) {
        IncidentDTO updatedIncident = incidentService.updateIncident(id, incidentDTO);
        if (updatedIncident != null) {
            return new ResponseEntity<>(updatedIncident, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
