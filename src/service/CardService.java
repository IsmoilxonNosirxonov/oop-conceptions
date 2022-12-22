package service;

import model.Card;

import java.util.UUID;


public class CardService extends BaseService{
    int index1=0;
    @Override
    public boolean add(Object object) {
        Card card = (Card) object;
        for (Card c:cardList) {
            if(c!=null){
                if(c.getCardNumber().equals(card.getCardNumber())){
                    return false;
                }
            }
        }
        card.setUserid(UserService.currentUserId);
        cardList[index1++]=card;
        return true;
    }
    /*public int cardsLength(){
        for (Card card : cardList) {
            if(card!=null){
                if(card.getUserid().equals(UserService.currentUserId)){
                    length++;
                }
            }
        }
        return length;
    }*/
    public Card[] myCards(UUID id){
        int length=0;
        for (Card card : cardList) {
            if(card!=null){
                if(card.getUserid().equals(id)){
                    length++;
                }
            }
        }
        Card myCardsList[]=new Card[length];
        int index2=0;
        for (Card card : cardList) {
            if(card!=null){
                if(card.getUserid().equals(id)){
                    myCardsList[index2++]=card;
                }
            }
        }
        return myCardsList;
    }

}
