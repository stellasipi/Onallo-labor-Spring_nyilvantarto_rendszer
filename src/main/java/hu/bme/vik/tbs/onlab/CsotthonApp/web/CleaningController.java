package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.dto.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cleanings")
public class CleaningController {

    @Autowired
    private CleaningService cleaningService;

    @GetMapping
    public List<CleaningDTO> getAllCleanings() {
        return cleaningService.getAllCleanings();
    }

    @GetMapping("/{cleaningId}/roomCleaning")
    public List<RoomCleaningDTO> getRoomCleaningsForCleanging(@PathVariable Integer cleaningId, @RequestParam(required = false) String roomName) {
        if (roomName == null) {
            return cleaningService.getRoomCleaningsForCleanging(cleaningId);
        } else {
            return cleaningService.getRoomCleaningsForCleangingByRoom(cleaningId, roomName);
        }
    }

    @GetMapping("/rooms")
    public List<RoomDTO> getRooms() {
        return cleaningService.getRooms();
    }

    @GetMapping("/pairings")
    public List<RoomCleaningItemPairingMapDTO> getPairings() {
        return cleaningService.getPairings();
    }

    @PostMapping
    public CleaningDTO createCleaning(@RequestBody List<RoomCleaningDTO> roomCleanings) {
        return cleaningService.createCleaning(roomCleanings);
    }

    @DeleteMapping("/{cleaningId}")
    public ResponseEntity<Integer> deleteCleaning(@PathVariable Integer cleaningId) {
        Boolean isRemoved = cleaningService.deleteCleaning(cleaningId);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cleaningId, HttpStatus.OK);
    }

}
