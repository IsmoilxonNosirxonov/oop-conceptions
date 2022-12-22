package service;

import model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardService extends BaseService{
    @Override
    public boolean add(Object object) {
        Card card=(Card)object;
        for (Card card1 : cardList) {
            if (card1.getCardNumber().equals(card.getCardNumber())){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getById(UUID id) {
        for (Card card1 : cardList) {
            if (card1.getId().equals(id)){
                return card1;
            }
        }
        return null;
    }

    public List<Card> cardList(final UUID userId){
        List<Card>userCardList=new ArrayList<>();
        for (Card card1 : cardList) {
            if (card1.getUserId().equals(userId))
                cardList.add(card1);
        }
        return userCardList;
    }
}
