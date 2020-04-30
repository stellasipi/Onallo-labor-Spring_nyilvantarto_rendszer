package hu.bme.vik.tbs.onlab.CsotthonApp.repository;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.ScoutGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoutGroupRepository extends JpaRepository<ScoutGroup,Integer> {
}
