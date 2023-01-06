package server.service;

import server.controller.UserController;
import server.enums.Role;
import server.model.Card;
import server.model.History;
import server.model.TransferType;
import server.model.User;

import java.util.*;
import java.util.stream.Stream;

public class UserService implements BaseService{
    public static void getBalance(UUID userId) {
        for (Card value : CARD_MAP.values()) {
            if(value.getUserId().equals(userId)) {
                System.out.println(value);
            }
        }
    }

    public static String getUserNameById(UUID id){
        for (User value : USER_MAP.values()) {
            if(value.getId().equals(id))return value.getFullName();
        }
        return null;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (User value : USER_MAP.values()) {
            if(value.getRole().equals(Role.USER))users.add(value);
        }
        return users;
    }

    public static Stream<Map.Entry<User, Integer>> getTopUsers() {
        List<User> users = UserController.getAllUsers();
        Map<User, Integer> topUsers = new HashMap<>();
        for (User user : users) {
            int sum = UserController.getAllSum(user.getId());
            topUsers.put(user, sum);
        }
        Set<Map.Entry<User, Integer>> entries = topUsers.entrySet();
        return entries.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }

    public static int getAllSum(UUID userid) {
        int sum = 0;
        for (History history1 : history) {
            if(history1.getTransferType().equals(TransferType.DEBIT) && findCardById(history1.getCardId()).getUserId().equals(userid)){
                sum+=history1.getAmount();
            }
        }
        return sum;
    }

    private static Card findCardById(UUID cardId) {
        for (Card value : CARD_MAP.values()) {
            if(value.getId().equals(cardId))return value;
        }
        return null;
    }
}
