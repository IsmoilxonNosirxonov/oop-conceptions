package click.server.controller;

import click.server.model.Card;
import click.server.service.UserService;

public class UserController {

    public static Double viewBalance(Card card) {
        return UserService.viewBalance(card);
    }

    public static boolean transfer(String cardNumber) {
        return UserService.transfer(cardNumber);
    }
}