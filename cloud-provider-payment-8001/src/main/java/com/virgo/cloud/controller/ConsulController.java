package com.virgo.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider/consul")
public class ConsulController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/")
    public ResponseEntity<String> getConsulServiceConfig(@Value("${virgo.info}") String key) {
        return ResponseEntity.ok("Consul Config：" + key + "\t" + "server port: " + port);
    }
}
