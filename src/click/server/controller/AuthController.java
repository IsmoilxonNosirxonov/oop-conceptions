package click.server.controller;

import click.server.dto.CardDto;
import click.server.dto.ResponseDto;
import click.server.dto.UserDto;
import click.server.service.AuthService;

public class AuthController {

    public static ResponseDto signIn(UserDto userDto) {
        return AuthService.signIn(userDto);
    }

    public static ResponseDto signUp(UserDto userDto) {
        return AuthService.signUp(userDto);
    }

    public static ResponseDto card(CardDto cardDto) {
        return AuthService.card(cardDto);
    }
}
