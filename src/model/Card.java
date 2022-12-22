package model;

import java.util.UUID;

public class Card extends BaseModel{
    private String cardNumber;
    private String expiryDate;
    private String ownerName;
    private double balance;
    private UUID userId;


    public Card(String cardNumber, String expiryDate, String ownerName, double balance, UUID userId) {
        super();
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.ownerName = ownerName;
        this.balance = balance;
        this.userId = userId;
    }
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Card() {
        super();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
                ", expiryDate='" + expiryDate + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
