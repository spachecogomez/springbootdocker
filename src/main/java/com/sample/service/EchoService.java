package com.sample.service;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Logger log = LogManager.getLogger(EchoService.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public String checkStatus() throws Exception{
        log.info("The method checkStatus was consumed.");
        return objectMapper.writeValueAsString("ok");
    }

}
