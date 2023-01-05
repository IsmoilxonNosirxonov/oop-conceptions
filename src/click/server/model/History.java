package click.server.model;

import java.util.Date;

public class History{
    private Card card;
    private String operation;
    private double amount;
    private Date date;

    public History(Card card, String operation, double amount) {
        this.card = card;
        this.operation = operation;
        this.amount = amount;
        date = new Date();
    }

    public Card getCard() {
        return card;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "card = " + card.getCardNumber() +
                ", operation = " + operation +
                ", amount = " + amount +
                ", date = " + date;
    }
}
