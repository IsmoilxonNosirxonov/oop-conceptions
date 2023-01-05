package server.service;

import server.model.History;
import server.model.TransferType;

public class P2PService implements BaseService{
    public static void p2p(String senderCardNumber, String receiverCardNumber, double amount){
        history.add(new History(CARD_MAP.get(senderCardNumber).getId(), amount, TransferType.DEBIT));
        history.add(new History(CARD_MAP.get(receiverCardNumber).getId(), amount, TransferType.CREDIT));
    }
}
