package hu.bme.vik.tbs.szakdolgozat.CsotthonApp.web;


import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.dto.RegisterDTO;
import hu.bme.vik.tbs.szakdolgozat.CsotthonApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity createLog(@RequestBody RegisterDTO registerDTO) {
        String userCreation= userService.createUser(registerDTO);
        if(userCreation.equals("")){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().body(userCreation);
        }
    }

}
