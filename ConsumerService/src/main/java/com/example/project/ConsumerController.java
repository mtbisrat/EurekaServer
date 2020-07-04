package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

  @Autowired
  RestTemplate restTemplate;



   @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetings() {
        String result = restTemplate.getForObject("http://producer-service/hello", String.class);
        return result;
    }


}
