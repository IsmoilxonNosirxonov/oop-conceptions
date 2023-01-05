package click;

import click.client.UI.MainUI;
import click.server.database.Database;
import click.server.model.Card;
import click.server.model.User;


public class Main {
    static {
        Card card = new Card("Husan","8600111122223333","0000");
        card.setBalance(12000);
        Database.CARDS.add(card);

        User user = new User("+998123456789","0000", card);
        Database.USERS.put(user.getId(), user);

        Card card1 = new Card("Imom","9860111122223333","0000");
        card1.setBalance(10000);
        Database.CARDS.add(card1);

        User user1 = new User("+998987654321","0000", card1);
        Database.USERS.put(user1.getId(), user1);
    }
    public static void main(String[] args) {
        MainUI.mainWindow();
    }
}
