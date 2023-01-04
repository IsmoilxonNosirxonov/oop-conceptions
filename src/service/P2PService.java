package service;

import model.Card;
import model.History;

import java.util.UUID;

public class P2PService extends BaseService{

    CardService cardService = new CardService();
    public History[] histories = new History[1000];
    private int index = 0;
    public boolean SendMoney(String receiverCard, double amount, String operatingCardNumber){
        for (Card card : cardList) {
            if(card != null){
                if(receiverCard.equals(card.getCardNumber()) && cardService.operatingCard(operatingCardNumber).getBalance() >= amount){
                    card.setBalance(card.getBalance() + amount);
                    cardService.operatingCard(operatingCardNumber).setBalance(cardService.operatingCard(operatingCardNumber).getBalance() - amount);
                    histories[index++] = new History(operatingCardNumber, receiverCard, amount);
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
