package com.projets.Defitech.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projets.Defitech.Service.DemandDTO;
import com.projets.Defitech.Service.DemandService;

import java.util.List;

@RestController
@RequestMapping("/api/demands")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @GetMapping
    public ResponseEntity<List<DemandDTO>> getAllDemands() {
        List<DemandDTO> demands = demandService.getAllDemands();
        return new ResponseEntity<>(demands, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandDTO> getDemandById(@PathVariable Long id) {
        DemandDTO demand = demandService.getDemandById(id);
        if (demand != null) {
            return new ResponseEntity<>(demand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DemandDTO> createDemand(@RequestBody DemandDTO demandDTO) {
        DemandDTO createdDemand = demandService.createDemand(demandDTO);
        return new ResponseEntity<>(createdDemand, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandDTO> updateDemand(@PathVariable Long id, @RequestBody DemandDTO demandDTO) {
        DemandDTO updatedDemand = demandService.updateDemand(id, demandDTO);
        if (updatedDemand != null) {
            return new ResponseEntity<>(updatedDemand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemand(@PathVariable Long id) {
        demandService.deleteDemand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
