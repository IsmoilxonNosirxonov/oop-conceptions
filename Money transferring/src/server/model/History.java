package server.model;

import java.util.UUID;

public class History extends BaseModel{
    private UUID cardId;
    private double amount;
    private TransferType transferType;

    public History(UUID cardId, double amount, TransferType transferType) {
        this.cardId = cardId;
        this.amount = amount;
        this.transferType = transferType;
    }

    public UUID getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return "History{" +
                "amount=" + amount +
                ", transferType=" + transferType +
                '}';
    }

}
