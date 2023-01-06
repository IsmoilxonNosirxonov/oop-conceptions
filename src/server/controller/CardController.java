package server.controller;
import server.exception.NotEnouthMoneyException;
import server.model.Card;
import server.model.History;
import server.service.CardService;
import java.util.List;
import java.util.UUID;

public class CardController {

    public static List<Card> getUserCards(UUID id) {
        return CardService.getUserCards(id);
    }

    public static Card getCardByNumber(String cardNumber) {
        return CardService.getCardByNumber(cardNumber);
    }

    public static void sendMoney(Card card, Card card1, double amount) throws NotEnouthMoneyException {
        CardService.sendMoney(card, card1, amount);
    }

    public static List<History> getCardHistory(UUID id) {
        return CardService.getCardHistory(id);
    }
}
