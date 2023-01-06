import model.Admin;
import model.Card;
import model.History;
import model.User;
import service.CardService;
import service.P2PService;
import service.UserService;
import java.util.InputMismatchException;
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
            System.out.println("1. Register, 2. Login, 3. Enter Admin Panel, 0. Exit");
            try {
                stepCode = scannerInt.nextInt();
            }catch (Exception e){
                System.out.println("Wrong input");
                scannerInt.nextLine();
                continue;
            }
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
                    } else if (!currentUser.isActive()) {
                        System.out.println("Your account was blocked by Administration!");
                    } else{
                        int stepCode2 = 100;
                        while(stepCode2 != 0){
                            System.out.println("1. Enter new Card, 2. View my Card Details, 3. Send Money, 4. View debit History, 5. View credit History, 0. Back");
                            try {
                                stepCode2 = scannerInt.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println("Wrong input");
                                scannerInt.nextLine();
                            }
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
                                    System.out.println("Your cards: ");
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
                                    System.out.println("\nEnter receiverCardNumber");
                                    String receiverCardNumber = scannerStr.nextLine();
                                    System.out.println("Enter amount");
                                    double amount = scannerInt.nextDouble();
                                    System.out.println("Enter your operating card number");
                                    String operatingCardNumber = scannerStr.nextLine();
                                    if(receiverCardNumber != null && operatingCardNumber != null && p2pService.SendMoney(receiverCardNumber, amount, operatingCardNumber)){
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
                case 3 -> {
                    System.out.println("Enter password: ");
                    String password = scannerStr.nextLine();
                    if (!password.equals(Admin.password)){
                        System.out.println("Wrong password!");
                    }else{
                        int stepCode3 = 1000;
                        while (stepCode3 != 0){
                            System.out.println("1. User List, 2. Blocked Users List, 3. Block User, 4. Unblock User, 5. Balance, 6. User charts, 0. Back");
                            try {
                                stepCode3 = scannerInt.nextInt();
                            } catch (InputMismatchException e){
                                System.out.println("Wrong input");
                                scannerInt.nextLine();
                            }
                            switch (stepCode3){
                                case 1 -> {
                                    int cnt = 0;
                                    for (User user : UserService.userList) {
                                        if (user != null && user.isActive()){
                                            System.out.println("========" + ++cnt + "========");
                                            System.out.println("Full name: " + user.getFullName());
                                            System.out.println("Phone number: " + user.getPhoneNumber());
                                        }
                                    }
                                }
                                case 2 -> {
                                    int cnt = 0;
                                    for (User user : UserService.userList) {
                                        if (user != null && !user.isActive()){
                                            System.out.println("========" + ++cnt + "========");
                                            System.out.println("Full name: " + user.getFullName());
                                            System.out.println("Phone number: " + user.getPhoneNumber());
                                        }
                                    }
                                }
                                case 3 -> {
                                    System.out.println("Enter full name of user that you want to block: ");
                                    String fullName = scannerStr.nextLine();
                                    if(userService.blockUser(fullName)){
                                        System.out.println("Succesfully blocked!");
                                    }else {
                                        System.out.println("Something went wrong!");
                                    }
                                }
                                case 4 -> {
                                    System.out.println("Enter full name of user that you want to block: ");
                                    String fullName = scannerStr.nextLine();
                                    if(userService.unclockUser(fullName)){
                                        System.out.println("Succesfully unlocked!");
                                    }else {
                                        System.out.println("Something went wrong!");
                                    }
                                }
                                case 5 -> {
                                    System.out.println("Your Balance is: " + Admin.balance);
                                }
                                case 6 -> {
                                    System.out.println("******** 1st place *********");
                                    System.out.println(p2pService.userCharts()[0]);
                                    System.out.println("******** 2nd place *********");
                                    System.out.println(p2pService.userCharts()[1]);
                                    System.out.println("******** 3rd place *********");
                                    System.out.println(p2pService.userCharts()[2]);
                                    P2PService.charts[0] = null;
                                    P2PService.charts[1] = null;
                                    P2PService.charts[2] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}