package hu.bme.vik.tbs.onlab.CsotthonApp.web;

import hu.bme.vik.tbs.onlab.CsotthonApp.model.User;
import hu.bme.vik.tbs.onlab.CsotthonApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
