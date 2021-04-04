package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.CleaningItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CleaningItemRepository extends JpaRepository<CleaningItem,Integer> {
    CleaningItem findByName(String name);
}
