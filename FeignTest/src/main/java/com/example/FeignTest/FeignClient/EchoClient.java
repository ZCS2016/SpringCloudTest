package com.example.FeignTest.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "Echo-Server")
public interface EchoClient {

    @RequestMapping(value = "/EchoServer/echo/{message}")
    public String echo(@PathVariable(value = "message") String message);
}