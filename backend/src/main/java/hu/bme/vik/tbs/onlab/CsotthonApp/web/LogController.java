package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.Log;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.LogRepository;
import hu.bme.vik.tbs.onlab.CsotthonApp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/logs")
public class LogController {
    @Autowired
    LogService logService;

    @Autowired
    LogRepository logRepository;

    @GetMapping
    public List<Log> getAll(){
        return logRepository.findAll();
    }

    @PostMapping
    public void createLog(@RequestBody Log log){
    	System.out.println("abc");
    }
}
