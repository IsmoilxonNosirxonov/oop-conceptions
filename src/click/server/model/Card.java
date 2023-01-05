package click.server.model;

public class Card extends Id_creator{
    private String cardNumber;
    private String ownerName;
    private String cardPassword;
    private double balance;

    public Card(String ownerName, String cardNumber, String cardPassword) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
        this.balance = 0;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

}
