package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.MaintenanceDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping()
    public List<MaintenanceDTO> getAll() {
        return maintenanceService.getAll();
    }

    @PostMapping
    public MaintenanceDTO createMaintenance(@RequestBody MaintenanceDTO maintenance) {
        return maintenanceService.createMaintenance(maintenance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteMaintenance(@PathVariable Integer id) {
        Boolean isRemoved = maintenanceService.delete(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(id);
    }
}
