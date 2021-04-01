package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.Room;
import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCleaningRepository extends JpaRepository<RoomCleaning, Integer> {
    List<RoomCleaning> findByCleaning(Cleaning cleaning);
    //List<RoomCleaning> findByCleaningAndRoom(Cleaning cleaning, Room room);
    List<RoomCleaning> findByCleaningAndRoomCleaningItemPairingRoomName(Cleaning cleaning, String roomName);
}
