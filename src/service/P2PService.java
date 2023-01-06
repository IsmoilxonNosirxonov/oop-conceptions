package service;

import model.Admin;
import model.Card;
import model.History;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class P2PService extends BaseService{

    CardService cardService = new CardService();
    public History[] histories = new History[1000];
    private int index = 0;
    public boolean SendMoney(String receiverCard, double amount, String operatingCardNumber){
        for (Card card : cardList) {
            if(card != null){
                if(receiverCard.equals(card.getCardNumber()) && CardService.operatingCard(operatingCardNumber).getBalance() >= (amount + amount * 0.01)){
                    Admin.balance += amount * 0.01;
                    card.setBalance(card.getBalance() + amount);
                    CardService.operatingCard(operatingCardNumber).setBalance(CardService.operatingCard(operatingCardNumber).getBalance() - (amount + amount * 0.01));
                    histories[index++] = new History(operatingCardNumber, receiverCard, amount);
                    return true;
                }
            }
        }
        return false;
    }
    public static String[] charts = new String[3];

    public String[] userCharts(){
        String top1 = "";
        String top2 = "";
        String top3 = "";
        int max = 0;
        int sum = 0;
        for (User user : UserService.userList) {
            if(user != null && user.isActive() && !user.getFullName().equals(top2) && !user.getFullName().equals(top3)){
                for (History history : histories) {
                    if (history != null){
                        if(CardService.cardOwnerByNumber(history.getSenderCardNumber()).equals(user.getFullName())){
                            sum += history.getAmount();
                            if(sum > max){
                                top1 = user.getFullName();
                                max = sum;
                                charts[0] = top1 + " with amount " + sum;
                            }
                        }
                    }
                }
            }
            sum = 0;
        }
        max = 0;
        for (User user : UserService.userList) {
            if(user != null && user.isActive() && !user.getFullName().equals(top1) && !user.getFullName().equals(top3)){
                for (History history : histories) {
                    if (history != null){
                        if(CardService.cardOwnerByNumber(history.getSenderCardNumber()).equals(user.getFullName())){
                            sum += history.getAmount();
                            if(sum > max){
                                top2 = user.getFullName();
                                max = sum;
                                charts[1] = top2 + " with amount " + sum;
                            }
                        }
                    }
                }
            }
            sum = 0;
        }
        max = 0;
        for (User user : UserService.userList) {
            if(user != null && user.isActive() && !user.getFullName().equals(top2) && !user.getFullName().equals(top1)){
                for (History history : histories) {
                    if (history != null){
                        if(CardService.cardOwnerByNumber(history.getSenderCardNumber()).equals(user.getFullName())){
                            sum += history.getAmount();
                            if(sum > max){
                                top3 = user.getFullName();
                                max = sum;
                                charts[2] = top3 + " with amount " + sum;
                            }
                        }
                    }
                }
            }
            sum = 0;
        }
        return charts;
    }

    @Override
    protected boolean add(Object object) {
        return false;
    }

    @Override
    protected Object getById(UUID id) {
        return null;
    }
}
