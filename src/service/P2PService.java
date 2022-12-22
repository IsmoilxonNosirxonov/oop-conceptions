package service;

import model.Card;
import model.History;
import model.User;


import java.util.Calendar;
import java.util.UUID;

public class P2PService extends BaseService{

    CardService cardService = new CardService();
    public History[] histories = new History[1000];
    private int index = 0;
    public boolean SendMoney(String senderCard, String receiverCard, double amount, User currentUser){
        for (Card card : cardList) {
            if(card != null){
                if(receiverCard.equals(card.getCardNumber()) && cardService.myCard(currentUser).getBalance() >= amount){
                    card.setBalance(card.getBalance() + amount);
                    cardService.myCard(currentUser).setBalance(cardService.myCard(currentUser).getBalance() - amount);
                    histories[index++] = new History(senderCard, receiverCard, amount);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    protected boolean add(Object object) {
        return false;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }
}
