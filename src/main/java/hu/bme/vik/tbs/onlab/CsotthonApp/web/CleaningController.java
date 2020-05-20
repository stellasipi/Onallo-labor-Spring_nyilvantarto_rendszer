package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.CleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomCleaningDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.dto.RoomDTO;
import hu.bme.vik.tbs.onlab.CsotthonApp.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cleanings")
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

    @GetMapping("/{cleaningId}/roomCleaning/{roomName}")
    public List<RoomCleaningDTO> getRoomCleaningsForCleangingByRoom(@PathVariable Integer cleaningId, @PathVariable String roomName){
        return cleaningService.getRoomCleaningsForCleangingByRoom(cleaningId, roomName);
    }

    @GetMapping("/rooms")
    public List<RoomDTO> getRooms(){
        return cleaningService.getRooms();
    }

    @PostMapping
    public List<RoomCleaningDTO> createCleaning(@RequestBody List<RoomCleaningDTO> roomCleanings){
        return cleaningService.createCleaing(roomCleanings);
    }

}
