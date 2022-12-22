package model;

import java.util.UUID;

public class Card extends BaseModel{
    private String cardNumber;
    private String expiryDate;
    private String fullName;
    private double balance;
    private UUID userid;

    public Card(String cardNumber, String expiryDate, String fullName, double balance) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.fullName = fullName;
        this.balance = balance;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
