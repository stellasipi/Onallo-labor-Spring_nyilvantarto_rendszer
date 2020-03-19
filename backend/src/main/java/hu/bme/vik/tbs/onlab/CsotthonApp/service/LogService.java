package hu.bme.vik.tbs.onlab.CsotthonApp.service;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.Log;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    LogRepository logRepository;

    public void createLog(Log log){

    }
}
