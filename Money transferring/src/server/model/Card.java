package server.model;

import server.service.UserService;

import java.time.LocalDate;
import java.util.UUID;

public class Card extends BaseModel{
    private String cardNumber;
    private LocalDate localDate;
    private String pinCode;
    private UUID userId;
    private double balance;

    public Card(String cardNumber, UUID userId, String pinCode) {
        this.pinCode = pinCode;
        this.cardNumber = cardNumber;
        this.userId = userId;
        this.localDate = LocalDate.now().plusYears(4);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expireDate='" + localDate + '\'' +
                ", user fullName=" + UserService.getUserNameById(userId) +
                ", balance=" + balance +
                '}';
    }
}
