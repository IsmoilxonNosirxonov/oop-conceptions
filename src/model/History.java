package model;

import java.util.UUID;

public class History {

    private UUID id;
    private UUID cardId;
    private double amount;
    private HistoryType historyType;

    public History() {
        this.id = UUID.randomUUID();
    }

    public History(UUID cardId, double amount, HistoryType historyType) {
        this.cardId = cardId;
        this.amount = amount;
        this.historyType = historyType;
    }

    public UUID getId() {
        return id;
    }


    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
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
}
