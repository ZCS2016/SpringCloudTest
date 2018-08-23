package com.example.EurekaClientTest.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EchoServer")
public class EchoServerController {

    @RequestMapping("/echo/{message}")
    public String echo(@PathVariable String message){
        return message;
    }
}
