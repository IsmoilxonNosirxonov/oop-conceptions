package click.server.dto;

public class CardDto {
    private String cardNumber;
    private String ownerName;
    private double balance;
    private String cardPassword;

    public CardDto(String ownerName, String cardNumber, String cardPassword) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
}
