package click.server.service;

import click.server.database.Database;
import click.server.dto.CardDto;
import click.server.dto.ResponseDto;
import click.server.dto.UserDto;
import click.server.model.Card;
import click.server.model.User;

public class AuthService {

    public static ResponseDto signIn(UserDto userDto) {
        String phoneNumber = userDto.getPhoneNumber();
        if (!phoneNumber.matches("\\+998\\d{9}")){
            return new ResponseDto("Invalid phone number ❌",false);
        }
        String password = userDto.getPassword();
        if (password==null || password.isBlank()){
            return new ResponseDto("Invalid password ❌",false);
        }

        for (User user : Database.USERS.values()) {
            if (user.getPhoneNumber().equals(phoneNumber)){
                if (user.getPassword().equals(password)){
                    return new ResponseDto(true, user.getCard());
                }
            }
        }

        return new ResponseDto("User not found ❌",false);
    }

    public static ResponseDto signUp(UserDto userDto) {
        String phoneNumber = userDto.getPhoneNumber();
        if (!phoneNumber.matches("\\+998\\d{9}")){
            return new ResponseDto("Invalid phone number ❌",false);
        }
        for (User user : Database.USERS.values()) {
            if (user.getPhoneNumber().equals(phoneNumber)){
                return new ResponseDto("Such a user exists ❌", false);
            }
        }
        String password = userDto.getPassword();
        if (password==null || password.isBlank()){
            return new ResponseDto("Invalid password ❌", false);
        }

        return new ResponseDto(true);
    }

    public static ResponseDto card(CardDto cardDto) {
        String ownerName = cardDto.getOwnerName();
        if (ownerName==null || ownerName.isBlank()){
            return new ResponseDto("Invalid user name ❌", false);
        }

        String cardNumber = cardDto.getCardNumber();
        if (!cardNumber.matches("(8600|9860)\\d{12}")){
            return new ResponseDto("Invalid card number ❌", false);
        }

        for (Card card : Database.CARDS) {
            if (card.getCardNumber().equals(cardNumber)){
                return new ResponseDto("There is such a card number ❌", false);
            }
        }
        String cardPassword = cardDto.getCardPassword();
        if (!cardPassword.matches("\\d{4}")){
            return new ResponseDto("Invalid card password ❌", false);
        }
        return new ResponseDto(true);
    }
}
