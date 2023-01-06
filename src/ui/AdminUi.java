package ui;
import server.controller.UserController;
import server.enums.Status;
import server.model.User;
import server.service.UserService;
import ui.util.UtilScanner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class AdminUi {

    public static void adminWindow(User user) {
        while (true){
            System.out.println("1. Show all users");
            System.out.println("2. Block or unblock");
            System.out.println("3. Show balance");
            System.out.println("4. Show top users");
            System.out.println("0. back");
            System.out.println("choose one: ");
            String choose = UtilScanner.SCANNER_STR.nextLine();
            switch (choose){
                case "1"-> getAllUsers();
                case "2"-> setStatus();
                case "3"-> UserController.getBalance(user.getId());
                case "4"-> getTopUsers();
                case "0"->{
                    return;
                }
            }
        }
    }

    private static void getTopUsers() {
        Stream<Map.Entry<User, Integer>> topUsers = UserController.getTopUsers();
        for (Map.Entry<User, Integer> topUsersInMap : topUsers.toList()) {
            System.out.println(topUsersInMap.getKey().getFullName() + ", total: " + topUsersInMap.getValue());
        }
        System.out.println();
    }
    private static void setStatus() {
        while (true){
            System.out.println("1. Block user");
            System.out.println("2. Unblock user");
            System.out.println("0. back");
            System.out.println("choose one: ");
            String choose = UtilScanner.SCANNER_STR.nextLine();
            switch (choose){
                case "1"->{
                    try {
                        User user = blockOrUnblock();
                        if(user.getStatus().equals(Status.BLOCKED)){
                            System.out.println("User has already been blocked\n");
                        }
                        else {
                            user.setStatus(Status.BLOCKED);
                            System.out.println("User has successfully been blocked\n");
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("User not found\n");
                    }catch (NullPointerException e){

                    }
                }
                case "2"->{
                    try {
                        User user = blockOrUnblock();
                        if(user.getStatus().equals(Status.UNBLOCKED)){
                            System.out.println("User has already been unblocked\n");
                        }
                        else {
                            user.setStatus(Status.UNBLOCKED);
                            System.out.println("User has successfully been unblocked\n");
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("User not found\n");
                    }catch (NullPointerException e){

                    }
                }
                case "0"->{
                    return;
                }
            }
        }
    }

    private static void getAllUsers() {
        List<User> users = UserController.getAllUsers();
        users.forEach(user -> System.out.println(user.getFullName()));
    }

    private static User blockOrUnblock(){
        List<User> users = UserController.getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i+1) + ". " +users.get(i).getFullName());
        }
        System.out.println("\nChoose user by his id");
        System.out.println("0. back");
        int index = UtilScanner.SCANNER_INT.nextInt();
        if(index == 0)return null;
        return users.get(index-1);
    }
}
