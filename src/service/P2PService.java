package service;

import model.Card;
import model.History;
import model.HistoryType;

import java.util.UUID;

import static service.BaseService.cardList;

public class P2PService {
   private static History[] historyList=new History[100];
   private int index=0;
   public double allBalance;
    public boolean p2p(final String senderCardNumber, final String receiverCardNumber, final double amount){
        // istoriyani ham shu yerda qilib ketasizlar
        for (Card card:cardList) {
         if(card.getCardNumber().equals(senderCardNumber) && card.getBalance()>amount){
             card.setBalance(card.getBalance()-amount);
             historyList[index++]=new History(card.getId(),amount,HistoryType.CREDIT);
         }
        }
        for (Card card:cardList) {
            if(card.getCardNumber().equals(receiverCardNumber) && card.getBalance()>amount){
                card.setBalance(card.getBalance()+amount);
                historyList[index++]=new History(card.getId(),amount,HistoryType.DEBIT);
            }
        }



        return true;
    }
}
