package server.service;

import server.exception.NotEnouthMoneyException;
import server.model.Card;
import server.model.History;
import server.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardService implements BaseService{
    public static List<Card> getUserCards(UUID id) {
        List<Card> cards = new ArrayList<>();
        for (Card value : CARD_MAP.values()) {
            if(value.getUserId().equals(id))cards.add(value);
        }
        return cards;
    }

    public static Card getCardByNumber(String cardNumber) {
        if (CARD_MAP.containsKey(cardNumber)){
            return CARD_MAP.get(cardNumber);
        }
        return null;
    }

    public static void sendMoney(Card card, Card card1, double amount) throws NotEnouthMoneyException {
        if(card.getBalance()<amount){
            throw new NotEnouthMoneyException("Not enough money");
        }
        card.setBalance(card.getBalance() - amount);
        card1.setBalance(card1.getBalance() + amount);
        P2PService.p2p(card.getCardNumber(), card1.getCardNumber(), amount);
    }

    public static List<History> getCardHistory(UUID id) {
        List<History> histories = new ArrayList<>();
        for (History history1 : history) {
            if(history1.getCardId().equals(id))histories.add(history1);
        }
        return histories;
    }
}
