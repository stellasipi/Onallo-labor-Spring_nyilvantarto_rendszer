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

    @GetMapping("/cleaningItems")
    public List<CleaningItemDTO> getCleaningItems() {
        return cleaningService.getCleaningItems();
    }

    @GetMapping("/pairings")
    public List<RoomCleaningItemPairingMapDTO> getPairings() {
        return cleaningService.getPairings();
    }

    @PostMapping
    public CleaningDTO createCleaning(@RequestBody List<RoomCleaningDTO> roomCleanings, Principal principal) {
        return cleaningService.createCleaning(roomCleanings, principal);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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
    public ResponseEntity createRoom(@RequestBody RoomDTO roomDTO) {
        RoomDTO room = cleaningService.createRoom(roomDTO);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.badRequest().body("A megadott név már létezik");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/cleaningItem")
    public ResponseEntity createCleaningItem(@RequestBody CleaningItemDTO cleaningItemDTO) {
        CleaningItemDTO cleaningItem = cleaningService.createCleaningItem(cleaningItemDTO);
        if (cleaningItem != null) {
            return ResponseEntity.ok(cleaningItem);
        } else {
            return ResponseEntity.badRequest().body("A megadott név már létezik");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/pairing")
    public ResponseEntity createRoomCleaningItemPairing(@RequestBody RoomCleaningItemPairingDTO roomCleaningItemPairingDTO) {
        RoomCleaningItemPairingDTO pairing = cleaningService.createRoomCleaningItemPairing(roomCleaningItemPairingDTO);
        if (pairing != null) {
            return ResponseEntity.ok(pairing);
        } else {
            return ResponseEntity.badRequest().body("A szoba vagy az elvégzendő feladat neve nem megfelelő vagy már létezik a párosítás");
        }
    }

}
