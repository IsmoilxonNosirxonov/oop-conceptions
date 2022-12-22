package service;

import model.Card;
import model.History;
import model.HistoryType;

import java.util.ArrayList;
import java.util.List;

public class P2PService {
public static List<History>historyList=new ArrayList<>();
    public boolean p2p(final String senderCardNumber, final String receiverCardNumber, final double amount) {
        for (Card card : BaseService.cardList) {
            if (card.getCardNumber().equals(senderCardNumber)&&card.getBalance() > amount) {
                    card.setBalance(card.getBalance()-amount);
                    historyList.add(new History(card.getId(),amount, HistoryType.CREDIT));
            }
            if (card.getCardNumber().equals(receiverCardNumber)){
                card.setBalance(card.getBalance()+amount);
                historyList.add(new History(card.getId(),amount, HistoryType.DEBIT));
            }
            return true;

        }
        return false;
    }
}
