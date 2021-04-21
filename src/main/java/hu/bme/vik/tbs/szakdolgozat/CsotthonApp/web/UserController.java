package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;

import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RegisterDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createLog(@RequestBody RegisterDTO registerDTO) {
        String userCreationMessage= userService.createUser(registerDTO);
        if(userCreationMessage.equals("")){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().body(userCreationMessage);
        }
    }

    @GetMapping("/scoutGroups")
    public ResponseEntity<List<String>> getExistingScoutGroups(){
        return ResponseEntity.ok(userService.getExistingScoutGroups());
    }

}
