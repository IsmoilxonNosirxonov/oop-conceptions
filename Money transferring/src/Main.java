
import server.model.Card;
import server.model.User;
import server.service.BaseService;
import ui.MainUi;

public class Main {

    static {
        User user = new User("Asadbek", "+998912596203", "1999");
        User user1 = new User("Nobleman", "+998911234567", "1234");

        Card card = new Card("0860111122223333", user.getId(), "6456");
        Card card1 = new Card("0860123412341234", user.getId(), "4968");
        Card card2 = new Card("0860111111111111", user1.getId(), "1985");

        card.setBalance(100);
        card1.setBalance(60);
        card2.setBalance(190);

        BaseService.USER_MAP.put(user.getPhoneNumber(), user);
        BaseService.USER_MAP.put(user1.getPhoneNumber(), user1);

        BaseService.CARD_MAP.put(card.getCardNumber(), card);
        BaseService.CARD_MAP.put(card1.getCardNumber(), card1);
        BaseService.CARD_MAP.put(card2.getCardNumber(), card2);
    }



    public static void main(String[] args) {
        MainUi.runMain();
    }
}