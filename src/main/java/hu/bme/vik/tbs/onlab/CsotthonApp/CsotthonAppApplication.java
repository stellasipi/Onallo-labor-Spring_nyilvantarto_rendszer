package hu.bme.vik.tbs.onlab.CsotthonApp;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.*;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.LogType;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Sex;
import hu.bme.vik.tbs.onlab.CsotthonApp.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@SpringBootApplication
public class CsotthonAppApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CsotthonAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
