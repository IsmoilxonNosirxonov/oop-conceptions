import model.Card;
import model.P2P;
import model.User;
import service.CardService;
import service.P2PService;
import service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService=new UserService();
        CardService cardService=new CardService();
        P2PService p2pService=new P2PService();
        Scanner scannerInt=new Scanner(System.in);
        Scanner scannerStr=new Scanner(System.in);
        int stepCode=100;
        while (stepCode!=0){
            System.out.println("1.Add User, 2.Login, 0.Exit");
            try{
                stepCode=scannerInt.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter only number!");
                scannerInt.nextLine();
            }
            User currentUser=null;
            switch (stepCode){
                case 1->{
                    System.out.println("enter phone number: ");
                    String phoneNumber=scannerStr.nextLine();
                    System.out.println("enter password: ");
                    String password=scannerStr.nextLine();
                    User user=new User(phoneNumber,password);
                    System.out.println(userService.add(user));
                }
                case 2->{
                    System.out.println("enter phone number: ");
                    String phoneNumber=scannerStr.nextLine();
                    System.out.println("enter password: ");
                    String password=scannerStr.nextLine();
                    currentUser=userService.login(phoneNumber,password);
                    if(currentUser==null){
                        System.out.println("Login or password incorrect.Please try again!");
                    }
                    else{
                        int stepCode2=100;
                        while (stepCode2!=0){
                            System.out.println("1.Add Card, 2.My Cards, 3.Add debt Card, 4.Monitoring, 0.Exit");
                            try{
                                stepCode2=scannerInt.nextInt();
                            }catch (InputMismatchException e){
                                System.out.println("Please enter only number!");
                                scannerInt.nextLine();
                            }
                            switch (stepCode2){
                                case 1->{
                                    System.out.println("enter Card number: ");
                                    String cardNumber=scannerStr.nextLine();
                                    System.out.println("enter expiry date: ");
                                    String expiryDate=scannerStr.nextLine();
                                    System.out.println("enter full name number: ");
                                    String fullName=scannerStr.nextLine();
                                    System.out.println("enter balance: ");
                                    Double balance= scannerInt.nextDouble();
                                    Card card=new Card(cardNumber,expiryDate,fullName,balance);
                                    System.out.println(cardService.add(card));
                                }
                                case 2->{
                                    Card myCardList[]= cardService.myCards(currentUser.getId());
                                    int cnt=0;
                                    for (Card c : myCardList) {
                                        System.out.println("================" + ++cnt+"-card ===========");
                                        System.out.println("Card Number: "+c.getCardNumber());
                                        System.out.println("Card Expiry Date: "+c.getExpiryDate());
                                        System.out.println("Card Full Name: "+c.getFullName());
                                        System.out.println("Card Balance: "+c.getBalance());
                                    }
                                }
                                case 3->{
                                    System.out.println("enter sender Card number: ");
                                    String senderCardNumber=scannerStr.nextLine();
                                    System.out.println("enter receiver Card number: ");
                                    String receiverCardNumber=scannerStr.nextLine();
                                    System.out.println("enter debt amount: ");
                                    double amount=scannerInt.nextDouble();
                                    P2P p2p=new P2P(senderCardNumber,receiverCardNumber,amount);
                                    System.out.println(p2pService.add(p2p));
                                }
                                case 4->{
                                    System.out.println("enter Card number: ");
                                    String cardNumber=scannerStr.nextLine();
                                    p2pService.myHistory(cardNumber);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}