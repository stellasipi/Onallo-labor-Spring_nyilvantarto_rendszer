package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/cleaning")
public class CleaningController {

    @Autowired
    CleaningService cleaningService;

    @GetMapping
    public List<CleaningDTO> getAllCleanings(){
        return cleaningService.getAllCleanings();
    }

    @GetMapping("/{cleaningId}/roomCleaning")
    public List<RoomCleaningDTO> getRoomCleaningsForCleanging(@PathVariable Integer cleaningId){
        return cleaningService.getRoomCleaningsForCleanging(cleaningId);
    }
}
