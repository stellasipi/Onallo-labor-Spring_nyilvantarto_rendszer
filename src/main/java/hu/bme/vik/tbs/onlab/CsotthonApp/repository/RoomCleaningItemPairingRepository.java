package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaningItemPairing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomCleaningItemPairingRepository extends JpaRepository<RoomCleaningItemPairing, Integer> {
    RoomCleaningItemPairing findByRoomNameAndCleaningItemName(String roomName, String CleaningItemName);
    List<RoomCleaningItemPairing> findByRoomName(String roomName);
}
