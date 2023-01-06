package ui;

import server.controller.AuthController;
import server.enums.Role;
import server.model.User;
import ui.util.UtilScanner;

public class AuthUi {
    public static void login() {
        System.out.println("Write phone number");
        String phoneNumber = UtilScanner.SCANNER_STR.nextLine();
        System.out.println("Write password");
        String password = UtilScanner.SCANNER_STR.nextLine();

        User user = AuthController.login(phoneNumber, password);
        if(user == null){
            System.out.println("user not found");
            return;
        }
        if(user.getRole().equals(Role.ADMIN)){
            AdminUi.adminWindow(user);
        }else {
            UserUi.userWindow(user);
        }
    }
}
