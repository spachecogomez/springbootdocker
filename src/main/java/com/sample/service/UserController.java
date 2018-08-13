package com.sample.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.entity.User;
import com.sample.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sebastianpacheco on 24/01/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private Logger log = LogManager.getLogger(UserController.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity createUser(@RequestBody User user){
        try{
            userRepository.save(user);
            log.info("User created");
            return ResponseEntity.ok().build();
        }catch(Exception e){
            log.error("Se produjo un error",e);
            return ResponseEntity.badRequest().build();
        }
    }



}
