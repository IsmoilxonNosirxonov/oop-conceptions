package service;

import model.Card;
import model.P2P;
import model.User;

import java.util.UUID;

public class P2PService extends BaseService{
    int length=0;
    int index1=0;
    @Override
    public boolean add(Object object) {
        P2P p2p=( P2P) object;
        for (Card card : cardList) {
            if (card!=null){
                if(card.getCardNumber().equals(p2p.getSenderCardNumber())){
                    card.setBalance(card.getBalance()-p2p.getAmount());
                    p2pList[index1++]=p2p;
                    return true;
                }
                if (card.getCardNumber().equals(p2p.getReceiverCardNumber())){
                    card.setBalance(card.getBalance()+p2p.getAmount());
                    p2pList[index1++]=p2p;
                    return true;
                }
            }
        }
        return false;
    }
    P2P myHistoryList[]=new P2P[length];
    public P2P[] myHistory(String cardNumber){
        for (P2P p2p : p2pList) {
            if (p2p!=null){
                if(p2p.getReceiverCardNumber().equals(cardNumber) || p2p.getSenderCardNumber().equals(cardNumber)){
                    length++;
                }
            }
        }
        P2P myHistoryList[]=new P2P[length];
        int index2=0;
        for (P2P p2p : p2pList) {
            if (p2p!=null){
                if(p2p.getReceiverCardNumber().equals(cardNumber) || p2p.getSenderCardNumber().equals(cardNumber)){
                    myHistoryList[index2++]=p2p;
                }
            }
        }
        return myHistoryList;
    }

}
