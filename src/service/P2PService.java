package service;

import model.Card;
import model.P2P;

public class P2PService extends BaseService{
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
    public void myHistory(String cardNumber){
        int index2=0;
        int cnt=0;
        for (P2P p2p : p2pList) {
            if (p2p!=null){
                if(p2p.getReceiverCardNumber().equals(cardNumber)){
                    System.out.println("================" + ++cnt+"-transaction ===========");
                    System.out.println("Sender Card number: "+p2p.getSenderCardNumber());
                    System.out.println("Receiver Card number: "+p2p.getReceiverCardNumber());
                    System.out.println("Debt amount: + "+p2p.getAmount());
                }
                if(p2p.getSenderCardNumber().equals(cardNumber)){
                    System.out.println("================" + ++cnt+"-transaction ===========");
                    System.out.println("Sender Card number: "+p2p.getSenderCardNumber());
                    System.out.println("Receiver Card number: "+p2p.getReceiverCardNumber());
                    System.out.println("Debt amount: - "+p2p.getAmount());
                }
            }
        }
    }

}
