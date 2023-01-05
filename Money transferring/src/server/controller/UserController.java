package server.controller;

import server.service.UserService;

import java.util.UUID;

public class UserController {
    public static void getBalance(UUID user) {
        UserService.getBalance(user);
    }
}
