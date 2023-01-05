package click.server.model;

public class User extends Id_creator {
    private String phoneNumber;
    private String password;
    private Card card;

    public User(String phoneNumber, String password, Card card) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
