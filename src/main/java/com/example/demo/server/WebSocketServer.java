package com.example.demo.server;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/test/{userId}")
public class WebSocketServer {

    public static ConcurrentHashMap<String, Session> userSessions;

    public static ConcurrentHashMap<String, Session> getUserSesssions() {
        if (userSessions == null) {
            userSessions = new ConcurrentHashMap<String, Session>();
        }
        return userSessions;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        getUserSesssions().put(userId, session);
    }

    public static void sendMessage(String userId, String message) throws IOException {
        if (getUserSesssions().containsKey(userId)) {
            getUserSesssions().get(userId).getBasicRemote().sendText(message);
        } else {
            throw new IOException("User not found: " + userId);
        }
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println("Error in WebSocket: " + error.getMessage());
        error.printStackTrace();
    }

    @OnClose
    public void onClose() {

    }

}
