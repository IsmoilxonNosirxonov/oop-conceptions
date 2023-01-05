package click.client.UI;

import click.client.Util.ScannerUtil;
import click.server.controller.UserController;
import click.server.database.Database;
import click.server.model.Card;
import click.server.model.History;

import java.util.Scanner;

public class CardUI {
    public static void cardUI(Card card) {
        while (true){
            String choose = chooseOperation();

            switch (choose){
                case "1" -> transfer(card);
                case "2" -> viewBalance(card);
                case "3" -> balanceReplenishment(card);
                case "4" -> paymentHistory(card);
                case "0" -> {
                    return;
                }
            }
        }
    }

    public static String chooseOperation(){
        System.out.println("\n1. Transfer | Transfer");
        System.out.println("2. View balance | Balansni ko'rish");
        System.out.println("3. Balance replenishment | Balansni to'ldirish");
        System.out.println("4. Payment history | To'lov tarixi");
        System.out.println("0. Exit | Chiqish");
        System.out.print("\nChoose one: ");
        return ScannerUtil.scanner.nextLine();
    }

    private static void transfer(Card card) {
        System.out.print("\nEnter card number: ");
        String cardNumber = ScannerUtil.scanner.nextLine();

        if (card.getCardNumber().equals(cardNumber)){
            System.out.println("You cannot enter your card number ❌");
            return;
        }

        boolean cardNum = UserController.transfer(cardNumber);
        if (!cardNum){
            System.out.println("No such card number exists ❌");
            return;
        }

        System.out.print("Amount of money max("+card.getBalance()+"): " );
        double money = new Scanner(System.in).nextDouble();

        if (money<0 || money>card.getBalance()){
            System.out.println("Max = " +card.getBalance()+ " ❌");
            return;
        }
        card.setBalance(card.getBalance()-money);

        Database.HISTORIES.add(new History(card, "Transfer CREDIT", money));

        for (Card cards : Database.CARDS) {
            if (cards.getCardNumber().equals(cardNumber)){
                cards.setBalance(cards.getBalance()+money);
                Database.HISTORIES.add(new History(cards, "Transfer DEBIT", money));
            }
        }
    }

    private static void viewBalance(Card card) {
        Double balance = UserController.viewBalance(card);
        if (balance!=null){
            System.out.println("\nBalance = " + balance);
        }
    }

    private static void balanceReplenishment(Card card) {
        System.out.print("Amount of money: ");
        double money = new Scanner(System.in).nextDouble();
        card.setBalance(card.getBalance()+money);
        Database.HISTORIES.add(new History(card, "Balance replenishment DEBIT", money));
    }

    private static void paymentHistory(Card card) {
        for (History history : Database.HISTORIES) {
            if (history.getCard().equals(card)){
                System.out.println(history);
            }
        }
    }
}
