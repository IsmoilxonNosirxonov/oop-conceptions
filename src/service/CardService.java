package service;

import model.Card;
import java.util.UUID;

public class CardService extends BaseService{

    private int index = 0;
    @Override
    public boolean add(Object object) {
        Card card = (Card) object;
        for (Card card1 : cardList) {
            if(card1 != null){
                if(card1.getCardNumber().equals(card.getCardNumber())){
                    return false;
                }
            }
        }
        card.setUserId(UserService.currentUserId);
        cardList[index++] = card;
        return true;
    }

    @Override
    public Object getById(UUID id) {
        for (Card card : cardList) {
            if(card != null){
                if(card.getId().equals(id)){
                    return card;
                }
            }
        }
        return null;
    }
    public static Card operatingCard(String operatingCardNumber){
        for (Card card : cardList) {
            if (card != null){
                if (card.getCardNumber().equals(operatingCardNumber)) {
                    return card;
                }
            }
        }
        return null;
    }
    public static String cardOwnerByNumber(String cardNUmber){
        for (Card card : cardList) {
            if(card != null){
                if(card.getCardNumber().equals(cardNUmber)){
                    return card.getOwnerName();
                }
            }
        }
        return null;
    }
}
