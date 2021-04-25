package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.*;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.CleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ResponseEntity<List<RoomCleaningDTO>> getRoomCleaningsForCleanging(@PathVariable Integer cleaningId, @RequestParam(required = false) String roomName) {
        List<RoomCleaningDTO> response = cleaningService.getRoomCleaningsForCleanging(cleaningId, roomName);
        if (!response.isEmpty()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
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
    public CleaningDTO createCleaning(@RequestBody List<RoomCleaningDTO> roomCleanings, Principal principal) {
        return cleaningService.createCleaning(roomCleanings, principal);
    }

    @DeleteMapping("/{cleaningId}")
    public ResponseEntity<Integer> deleteCleaning(@PathVariable Integer cleaningId) {
        Boolean isRemoved = cleaningService.deleteCleaning(cleaningId);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cleaningId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/room")
    public RoomDTO createRoom(@RequestBody RoomDTO room){
        //TODO
        return cleaningService.createRoom(room);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/cleaningItem")
    public CleaningItemDTO createCleaningItem(@RequestBody CleaningItemDTO cleaningItemDTO){
        //TODO
        return cleaningService.createCleaningItem(cleaningItemDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/pairings")
    public void createRoomCleaningItemPairing(){
        //TODO
        //return cleaningService.createCleaningItem(cleaningItemDTO);
    }

}
