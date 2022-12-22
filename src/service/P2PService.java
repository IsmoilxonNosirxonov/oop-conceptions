package service;

import model.Card;
import model.History;


import java.util.UUID;

public class P2PService extends BaseService{

    public History[] histories = new History[1000];
    private int index = 0;
    public boolean SendMoney(String senderCard, String receiverCard, double amount){
        for (Card card : cardList) {
            if(card != null){
                if(receiverCard.equals(card.getCardNumber())){
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
