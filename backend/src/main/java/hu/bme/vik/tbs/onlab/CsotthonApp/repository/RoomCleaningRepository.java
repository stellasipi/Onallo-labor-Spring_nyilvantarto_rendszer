package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.RoomCleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomCleaningRepository extends JpaRepository<RoomCleaning,Integer> {
}
