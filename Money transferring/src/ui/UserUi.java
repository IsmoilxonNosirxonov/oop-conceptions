package ui;

import server.controller.CardController;
import server.controller.UserController;
import server.exception.NotEnouthMoneyException;
import server.model.Card;
import server.model.History;
import server.model.User;
import ui.util.UtilScanner;
import java.util.List;
import java.util.UUID;

public class UserUi {
    public static void userWindow(User user) {
        while (true){
            System.out.println("1. Show balance");
            System.out.println("2. Send money");
            System.out.println("3. Show history");
            System.out.println("0. back");
            System.out.println("choose one: ");
            String choose = UtilScanner.SCANNER_STR.nextLine();
            switch (choose){
                case "1"-> UserController.getBalance(user.getId());
                case "2"-> transferringMoney(user.getId());
                case "3"-> printHistory(user.getId());
                case "0"->{
                    return;
                }
            }
        }
    }

    private static void printHistory(UUID userId) {
        Card card = chooseCard(userId);
        if(card == null){
            System.out.println("Card not found");
            return;
        }

        List<History> histories = CardController.getCardHistory(card.getId());
        if(!histories.isEmpty()){
            histories.forEach(System.out::println);
        }
        else System.out.println("There is no any transactions");
    }

    private static void transferringMoney(UUID userId) {
        Card card = chooseCard(userId);
        if(card == null){
            System.out.println("card not found");
            return;
        }
        System.out.println("Write card number (16 digits)");
        String cardNumber = UtilScanner.SCANNER_STR.nextLine();
        Card card1 = CardController.getCardByNumber(cardNumber);
        if(card1 == null){
            System.out.println("card not found");
            return;
        }
        if(card.getId().equals(card1.getId())){
            System.out.println("you cannot send money the same card");
            return;
        }

        System.out.println("\n Write amount (max amount " + card.getBalance() + " )");
        double amount = UtilScanner.SCANNER_INT.nextInt();

        try {
            CardController.sendMoney(card, card1, amount);
            System.out.println("Money sent");
        } catch (NotEnouthMoneyException e) {
            e.printStackTrace();
        }
    }

    private static Card chooseCard(UUID userId){
        System.out.println("List of your Cards");
        List<Card> userCards = CardController.getUserCards(userId);
        for (int i = 0; i < userCards.size(); i++) {
            System.out.println((i+1) +  " - Card, balance: " +  userCards.get(i).getBalance());
        }
        System.out.println("\nchoose card number above");
        int number = UtilScanner.SCANNER_INT.nextInt();
        if(number < 1 || number > userCards.size()){
            return null;
        }
        return userCards.get(number-1);
    }

}
