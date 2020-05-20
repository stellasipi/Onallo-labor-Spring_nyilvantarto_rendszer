package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleaningRepository extends JpaRepository<Cleaning,Integer> {
    List<Cleaning> getAllByOrderByTimeDesc();
}
