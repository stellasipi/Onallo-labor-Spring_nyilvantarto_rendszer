package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Cleaning;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.RoomCleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCleaningRepository extends JpaRepository<RoomCleaning, Integer> {
    List<RoomCleaning> findByCleaning(Cleaning cleaning);
    List<RoomCleaning> findByCleaningAndRoomCleaningItemPairingRoomName(Cleaning cleaning, String roomName);
}
