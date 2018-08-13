package com.sample.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.entity.User;
import com.sample.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by sebastianpacheco on 24/01/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

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

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json", path = "/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name){
        return ResponseEntity.ok(userRepository.findUserByNameLike("%".concat(name).concat("%")));
    }



}
