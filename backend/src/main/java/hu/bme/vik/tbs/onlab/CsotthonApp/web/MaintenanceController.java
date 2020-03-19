package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.Maintenance;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/maintenances")
public class MaintenanceController {
    @Autowired
    MaintenanceRepository maintenanceRepository;

    @GetMapping(value="/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Maintenance>> getAll(){
        return new ResponseEntity<>(maintenanceRepository.findAll(), HttpStatus.OK);
    }
}
