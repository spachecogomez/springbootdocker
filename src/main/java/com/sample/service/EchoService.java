package com.sample.service;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sebastianpacheco on 24/01/17.
 */
@SpringBootConfiguration
@RestController("/healthcheck")
public class EchoService {

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public String checkStatus(){
        return "ok";
    }

}
