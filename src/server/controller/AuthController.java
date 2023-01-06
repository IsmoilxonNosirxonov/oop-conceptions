package server.controller;

import server.model.User;
import server.service.AuthService;

public class AuthController {
    public static User login(String phoneNumber, String password) {
        return AuthService.login(phoneNumber, password);
    }
}
