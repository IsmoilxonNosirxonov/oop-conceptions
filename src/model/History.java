package model;

import java.util.UUID;

public class History {

    private UUID id;
    private String senderCardNumber;
    private String receiverCardNumber;
    private double amount;
    private HistoryType historyType;

    public History() {
        this.id = UUID.randomUUID();
    }

    public History(String senderCardNumber, String receiverCardNumber, double amount) {
        this.senderCardNumber = senderCardNumber;
        this.receiverCardNumber = receiverCardNumber;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getReceiverCardNumber() {
        return receiverCardNumber;
    }

    public void setReceiverCardNumber(String receiverCardNumber) {
        this.receiverCardNumber = receiverCardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", senderCardNumber='" + senderCardNumber + '\'' +
                ", receiverCardNumber='" + receiverCardNumber + '\'' +
                ", amount=" + amount +
                ", historyType=" + historyType +
                '}';
    }
}
