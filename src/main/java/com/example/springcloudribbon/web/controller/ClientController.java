package com.example.springcloudribbon.web.controller;

import com.example.springcloudribbon.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {


    @Autowired
    private RestTemplate restTemplate;



    @Value("${serivce-provider.host}")
    private String serviceProviderHost;


    @Value("${serivce-provider.port}")
    private Integer serviceProviderPort;


    @GetMapping("")
    public String index() {

        User user = new User();
        user.setId(1L);
        user.setName("zzz");

        return restTemplate.postForObject("http://"+serviceProviderHost+":"+serviceProviderPort+"/greeting",
                user, String.class);
    }


}































