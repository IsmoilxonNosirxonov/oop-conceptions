package click.server.dto;

import click.server.model.Card;

public class ResponseDto {
    private boolean isSuccess;
    private String answer;
    private Card card;

    public ResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ResponseDto(String answer, boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.answer = answer;
    }

    public ResponseDto(boolean isSuccess, Card card) {
        this.isSuccess = isSuccess;
        this.card = card;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getAnswer() {
        return answer;
    }

    public Card getCard() {
        return card;
    }
}
