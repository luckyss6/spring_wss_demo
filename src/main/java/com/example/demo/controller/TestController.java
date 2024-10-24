package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.server.WebSocketServer;

@RestController
public class TestController {

    @GetMapping("/test/{userId}")
    public void test(@PathVariable String userId) throws IOException {
        WebSocketServer.sendMessage(userId, "Hello from server");
    }
}



