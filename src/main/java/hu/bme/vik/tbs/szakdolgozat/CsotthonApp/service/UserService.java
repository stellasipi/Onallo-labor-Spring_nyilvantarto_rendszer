package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RegisterDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.ScoutGroup;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.User;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(RegisterDTO registerDTO) {
        if (registerDTO.getName() == null || registerDTO.getName().equals("") ||
                registerDTO.getUsername() == null || registerDTO.getUsername().equals("") ||
                registerDTO.getPassword() == null || registerDTO.getPassword().equals("") ||
                registerDTO.getScoutGroup() == null || registerDTO.getGroupLeader().equals("")) {
            return "Nem lehet üres egy mező sem.";
        } else {
            User existingUsername = userRepository.findByUsername(registerDTO.getUsername());
            if (existingUsername != null) {
                return "Ez a felhasználónév már foglalt.";
            } else {
                User newUser = User.builder()
                        .name(registerDTO.getName())
                        .username(registerDTO.getUsername())
                        .password(passwordEncoder.encode(registerDTO.getPassword()))
                        .scoutGroup(scoutGroupRepository.findByName(registerDTO.getScoutGroup()))
                        .groupLeader(registerDTO.getGroupLeader())
                        .scout(true)
                        //arraylisteket inicializálni kéne?
                        .build();
                userRepository.save(newUser);
                return "";
            }
        }
    }

    public List<String> getExistingScoutGroups() {
        List<String> scoutGroupsNames = new ArrayList<>();
        List<ScoutGroup> scoutGroups = scoutGroupRepository.findAll();
        if (!scoutGroups.isEmpty()) {
            for (ScoutGroup scoutGroup : scoutGroups) {
                scoutGroupsNames.add(scoutGroup.getName());
            }
        }
        return scoutGroupsNames;
    }

}
