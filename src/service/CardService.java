package service;

import model.Card;
import model.User;

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
        for (Card card:cardList) {
            if(card!=null){
                if(card.getId().equals(id)){
                    return card;
                }
            }
        }
        return null;
    }
       private   int index1=0;
    public Card[] cardList(final UUID userId){
        Card[] userCardList=new Card[100];
        for (Card card : cardList) {
            if(card!=null){
                if(card.getUserId().equals(userId)){
                  userCardList[index1++]=card;
                }
            }
        }
        return null;
    }
}
