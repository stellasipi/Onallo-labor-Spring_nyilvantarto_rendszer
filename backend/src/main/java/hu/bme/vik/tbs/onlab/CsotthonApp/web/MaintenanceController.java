package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.LogDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.MaintenanceDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Maintenance;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.MaintenanceRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/maintenances")
public class MaintenanceController {
    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping()
    public List<MaintenanceDTO> getAll(){
        return maintenanceService.getAll();
    }

    @PostMapping
    public MaintenanceDTO createLog(@RequestBody MaintenanceDTO maintenance){
        return maintenanceService.createMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteLog(@PathVariable Integer id){
        Boolean isRemoved=maintenanceService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
