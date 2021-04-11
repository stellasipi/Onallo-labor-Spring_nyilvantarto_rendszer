package hu.bme.vik.tbs.szakdolgozat.CsotthonApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsotthonAppApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CsotthonAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
