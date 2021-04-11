package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.ScoutGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoutGroupRepository extends JpaRepository<ScoutGroup,Integer> {
    ScoutGroup findByName(String name);
}
