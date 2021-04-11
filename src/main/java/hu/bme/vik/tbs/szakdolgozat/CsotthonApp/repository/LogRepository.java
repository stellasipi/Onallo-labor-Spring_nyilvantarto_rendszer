package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer> {
    List<Log> findAllByOrderByTimeDesc();
}
