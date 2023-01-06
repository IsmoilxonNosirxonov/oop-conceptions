package server.controller;

import server.model.User;
import server.service.UserService;

import java.util.*;
import java.util.stream.Stream;

public class UserController {
    public static void getBalance(UUID user) {
        UserService.getBalance(user);
    }

    public static List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    public static Stream<Map.Entry<User, Integer>> getTopUsers() {
        return UserService.getTopUsers();
    }

    public static int getAllSum(UUID user) {
        return UserService.getAllSum(user);
    }
}
