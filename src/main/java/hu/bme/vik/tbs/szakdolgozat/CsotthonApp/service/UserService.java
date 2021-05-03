package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RegisterDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RoleDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.UserDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper.RoleMapper;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.mapper.UserMapper;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.Role;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.ScoutGroup;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.model.User;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.RoleRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.ScoutGroupRepository;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoutGroupRepository scoutGroupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final RoleMapper roleMapper;

    public UserService() {
        userMapper = Mappers.getMapper(UserMapper.class);
        roleMapper = Mappers.getMapper(RoleMapper.class);
    }

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
                        .build();
                if (newUser.getGroupLeader()) {
                    Role admin = roleRepository.findByName("ADMIN");
                    newUser.setRoles(new ArrayList<>() {{
                        add(admin);
                    }});
                } else {
                    Role user = roleRepository.findByName("USER");
                    newUser.setRoles(new ArrayList<>() {{
                        add(user);
                    }});
                }
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

    @Transactional
    public String changeUserRole(Integer userId, List<RoleDTO> roleDTOs, Boolean overwriteExisting) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            return "Ez a felhasználó nem létezik";
        }

        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOs) {
            Role role = roleRepository.findByName(roleDTO.getName());
            if (role == null) {
                return "Az egyik felsorolt szerepkör nem létezik";
            }
            roles.add(role);
        }

        if (overwriteExisting) {
            user.get().setRoles(roles);
        } else {
            for (Role role : roles) {
                if (!user.get().getRoles().contains(role)) {
                    user.get().getRoles().add(role);
                }
            }
        }

        userRepository.save(user.get());

        return "";
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(userMapper.userToUserDTO(user));
        }
        return userDTOs;
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : roles) {
            roleDTOs.add(roleMapper.roleToRoleDTO(role));
        }
        return roleDTOs;
    }

    public UserDTO getUser(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return userMapper.userToUserDTO(user);
    }
}
