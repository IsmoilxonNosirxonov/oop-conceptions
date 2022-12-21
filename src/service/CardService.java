package service;

import model.Card;

import java.util.UUID;

public class CardService extends BaseService{
private int index=0;
    @Override
    protected boolean add(Object object) {
        Card card=(Card) object;
        for (Card card1:cardList) {
            if(card1!=null){
                if(card1.getCardNumber().equals(card.getCardNumber())){
                    return false;
                }
            }
        }
        cardList[index++]=card;
        return true;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }

    public Card[] cardList(final UUID userId){

        return null;
    }
}
