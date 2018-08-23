package com.example.RibbonTest.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/EchoClient")
public class EchoClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/echo/{message}")
    public String echo(@PathVariable String message){
        String echoMessage = restTemplate.getForObject("http://Echo-Server/EchoServer/echo/" + message, String.class);
        return echoMessage;
    }

    @RequestMapping("/log-instance")
    public String logInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("Echo-Server");
        String log = "ServiceId: " + serviceInstance.getServiceId() + "\n"
                        + "Host: " + serviceInstance.getHost() + "\n"
                        + "Port: " + serviceInstance.getPort();
        return log;
    }

}
