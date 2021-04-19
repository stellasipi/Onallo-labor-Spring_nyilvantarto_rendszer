package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.util;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.User;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUserCreator {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    private void init(){
        //test data insertion, password encode issue in SQL script

        User user1=User.builder()
                .name("Tóth-Baranyi Stella")
                .username("stellasipi")
                .password(encoder.encode("password1"))
                .scoutGroup(scoutGroupRepository.findByName("Levendula"))
                .groupLeader(true)
                .scout(true)
                .build();
        userRepository.save(user1);

        User user2=User.builder()
                .name("Kovács Dávid")
                .username("dadikovi")
                .password(encoder.encode("password2"))
                .scoutGroup(scoutGroupRepository.findByName("Szalamandra"))
                .groupLeader(true)
                .scout(true)
                .build();
        userRepository.save(user2);
    }
}
