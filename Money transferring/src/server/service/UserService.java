package server.service;

import server.model.Card;
import server.model.User;

import java.util.UUID;

public class UserService implements BaseService{
    public static void getBalance(UUID userId) {
        for (Card value : CARD_MAP.values()) {
            if(value.getUserId().equals(userId)) System.out.println(value);
        }
    }

    public static String getUserNameById(UUID id){
        for (User value : USER_MAP.values()) {
            if(value.getId().equals(id))return value.getFullName();
        }
        return null;
    }

}
