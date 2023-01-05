package click.server.service;

import click.server.database.Database;
import click.server.model.Card;

public class UserService {

    public static Double viewBalance(Card card) {
        for (Card cards : Database.CARDS) {
            if (cards.getId().equals(card.getId())){
                return cards.getBalance();
            }
        }
        return null;
    }

    public static boolean transfer(String cardNumber) {
        for (Card cards : Database.CARDS) {
            if (cards.getCardNumber().equals(cardNumber)){
                return true;
            }
        }
        return false;
    }
}
