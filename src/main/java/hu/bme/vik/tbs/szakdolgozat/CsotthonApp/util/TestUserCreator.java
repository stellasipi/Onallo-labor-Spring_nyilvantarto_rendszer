package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.util;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Role;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.User;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.RoleRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TestUserCreator {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    //test data insertion, password encode issue in SQL script
    @PostConstruct
    private void init() {
        Role userRole = roleRepository.findByName("USER");
        Role adminRole = roleRepository.findByName("ADMIN");

        List<Role> user_admin = new ArrayList<>(){{
            add(adminRole);
            add(userRole);
        }};
        List<Role> user = new ArrayList<>(){{
            add(userRole);
        }};
        List<Role> admin = new ArrayList<>(){{
            add(adminRole);
        }};

        User user1 = User.builder()
                .name("Tóth-Baranyi Stella")
                .username("stellasipi")
                .password(encoder.encode("password1"))
                .roles(user_admin)
                .scoutGroup(scoutGroupRepository.findByName("Levendula"))
                .groupLeader(true)
                .scout(true)
                .build();

        User user2 = User.builder()
                .name("Kovács Dávid")
                .username("dadikovi")
                .password(encoder.encode("password2"))
                .roles(admin)
                .scoutGroup(scoutGroupRepository.findByName("Szalamandra"))
                .groupLeader(true)
                .scout(true)
                .build();

        User user3 = User.builder()
                .name("Teszt Elek")
                .username("tesztelek")
                .password(encoder.encode("password3"))
                .roles(user)
                .scoutGroup(scoutGroupRepository.findByName("Jaguár"))
                .groupLeader(false)
                .scout(true)
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
