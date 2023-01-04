import model.Card;
import model.History;
import model.User;
import service.CardService;
import service.P2PService;
import service.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in)   ;
        CardService cardService = new CardService();
        UserService userService = new UserService();
        P2PService p2pService = new P2PService();
        int stepCode = 100;
        while(stepCode != 0){
            System.out.println("1. Add User, 2. Login");
            stepCode = scannerInt.nextInt();
            switch (stepCode){
                case 1 -> {
                    System.out.println("Enter Full Name:");
                    String fullName = scannerStr.nextLine();
                    System.out.println("Enter Phone number");
                    String phoneNumber = scannerStr.nextLine();
                    System.out.println("Enter password");
                    String password = scannerStr.nextLine();
                    User user = new User(fullName, phoneNumber, password);
                    System.out.println(userService.add(user));
                }
                case 2 -> {
                    System.out.println("Enter Full Name:");
                    String fullName = scannerStr.nextLine();
                    System.out.println("Enter password");
                    String password = scannerStr.nextLine();
                    User currentUser = userService.login(fullName, password);
                    if(currentUser == null){
                        System.out.println("Wrong password or username");
                    }else{
                        int stepCode2 = 100;
                        while(stepCode2 != 0){
                            System.out.println("1. Enter new Card, 2. View my Card Details, 3. Send Money, 4. View debit History, 5. View credit History, 0. Back");
                            stepCode2 = scannerInt.nextInt();
                            switch (stepCode2){
                                case 1 -> {
                                    System.out.println("Enter Card number:");
                                    String cardNumber = scannerStr.nextLine();
                                    System.out.println("Enter Expiry Date:");
                                    String expiryDate = scannerStr.nextLine();
                                    String ownerName = currentUser.getFullName();
                                    System.out.println("Enter Card Balance:");
                                    double balance = scannerInt.nextDouble();
                                    UUID userId = currentUser.getId();
                                    Card card = new Card(cardNumber, expiryDate, ownerName, balance, userId);
                                    System.out.println(cardService.add(card));
                                }
                                case 2 -> {
                                    String name = currentUser.getFullName();
                                    int cnt = 0;
                                    for (Card card : CardService.cardList) {
                                        if(card != null){
                                            if(card.getOwnerName().equals(name)) {
                                                System.out.println("========" + ++cnt + "========");
                                                System.out.println("Card Number = " + card.getCardNumber());
                                                System.out.println("Card Owner = " + card.getOwnerName());
                                                System.out.println("Card Expiry Date = " + card.getExpiryDate());
                                                System.out.println("Card Balance = " + card.getBalance());
                                            }
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Enter receiverCardNumber");
                                    String receiverCardNumber = scannerStr.nextLine();
                                    System.out.println("Enter amount");
                                    double amount = scannerInt.nextDouble();
                                    System.out.println("Enter your operating card number");
                                    String operatingCardNumber = scannerStr.nextLine();
                                    if(p2pService.SendMoney(receiverCardNumber, amount, operatingCardNumber)){
                                        System.out.println("Money has succesfully transfered");
                                    }else{
                                        System.out.println("Transaction error!");
                                    }
                                }
                                case 4 -> {
                                    for (History history : p2pService.histories) {
                                        if(history != null){
                                            if(CardService.cardOwnerByNumber(history.getReceiverCardNumber()).equals(currentUser.getFullName())){
                                                System.out.println("Sender: " + history.getSenderCardNumber());
                                                System.out.println("Amount: " + history.getAmount());
                                            }
                                        }
                                    }
                                }
                                case 5 -> {
                                    for (History history : p2pService.histories) {
                                        if(history != null){
                                            if(CardService.cardOwnerByNumber(history.getSenderCardNumber()).equals(currentUser.getFullName())){
                                                System.out.println("Reciever: " + history.getReceiverCardNumber());
                                                System.out.println("Amount: " + history.getAmount());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}