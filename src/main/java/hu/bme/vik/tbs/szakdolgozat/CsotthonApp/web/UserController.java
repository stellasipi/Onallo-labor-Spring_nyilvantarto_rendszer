package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RegisterDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RoleDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.UserDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createLog(@RequestBody RegisterDTO registerDTO) {
        String userCreationMessage = userService.createUser(registerDTO);
        if (userCreationMessage.equals("")) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body(userCreationMessage);
        }
    }

    @GetMapping("/scoutGroups")
    public ResponseEntity<List<String>> getExistingScoutGroups() {
        return ResponseEntity.ok(userService.getExistingScoutGroups());
    }

    @PutMapping("/user/{userId}/role")
    public ResponseEntity changeUserRole(@PathVariable Integer userId, @RequestBody List<RoleDTO> roleDTOs, @RequestParam (required = true) Boolean overwriteExisting) {
        String userRoleChangeMessage = userService.changeUserRole(userId, roleDTOs, overwriteExisting);
        if(userRoleChangeMessage.equals("")){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().body(userRoleChangeMessage);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
