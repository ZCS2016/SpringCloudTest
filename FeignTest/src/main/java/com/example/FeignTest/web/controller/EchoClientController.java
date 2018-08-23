package com.example.FeignTest.web.controller;

import com.example.FeignTest.FeignClient.EchoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EchoClient")
public class EchoClientController {

    @Autowired
    private EchoClient echoClient;

    @RequestMapping("/echo/{message}")
    public String echo(@PathVariable String message){
        String echoMessage = echoClient.echo(message);
        return echoMessage;
    }

}
