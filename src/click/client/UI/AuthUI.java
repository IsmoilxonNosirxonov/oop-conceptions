package click.client.UI;

import click.client.Util.ScannerUtil;
import click.server.controller.AuthController;
import click.server.database.Database;
import click.server.dto.CardDto;
import click.server.dto.ResponseDto;
import click.server.dto.UserDto;
import click.server.model.Card;
import click.server.model.User;


public class AuthUI {
    public static void signIn() {
        System.out.print("\nEnter phone number: ");
        String phoneNumber = ScannerUtil.scanner.nextLine();

        System.out.print("Enter password: ");
        String password = ScannerUtil.scanner.nextLine();

        UserDto userDto = new UserDto(phoneNumber, password);
        ResponseDto responseDto = AuthController.signIn(userDto);
        if (!responseDto.isSuccess()){
            System.out.println("\n" +responseDto.getAnswer());
            return;
        }
        CardUI.cardUI(responseDto.getCard());
    }

    public static void signUp() {
        System.out.print("\nEnter phone number: ");
        String phoneNumber = ScannerUtil.scanner.nextLine();

        System.out.print("Enter password: ");
        String password = ScannerUtil.scanner.nextLine();

        UserDto userDto = new UserDto(phoneNumber, password);
        ResponseDto responseDto = AuthController.signUp(userDto);

        if (!responseDto.isSuccess()){
            System.out.println("\n" +responseDto.getAnswer());
            return;
        }
        while (true){
            System.out.print("\nEnter user name: ");
            String ownerName = ScannerUtil.scanner.nextLine();

            System.out.print("Enter card number: ");
            String cardNumber = ScannerUtil.scanner.nextLine();

            System.out.print("Enter card password: ");
            String cardPassword = ScannerUtil.scanner.nextLine();

            CardDto cardDto = new CardDto(ownerName, cardNumber, cardPassword);
            ResponseDto responseDto1 = AuthController.card(cardDto);
            if (!responseDto1.isSuccess()){
                System.out.println("\n" +responseDto1.getAnswer());
            }else {
                Card card = new Card(ownerName, cardNumber, cardPassword);
                User user = new User(phoneNumber, password, card);
                Database.USERS.put(user.getId(), user);
                Database.CARDS.add(card);

                CardUI.cardUI(card);
                return;
            }
        }


    }
}
