import service.BaseService;
import service.CardService;
import service.P2PService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CardService cardService = new CardService();
        P2PService p2PService = new P2PService();
        Scanner scannerStr=new Scanner(System.in);
        Scanner scannerNum=new Scanner(System.in);

        System.out.printf("1.login 2.add user ");
        int step=scannerNum.nextInt();
        while (step!=0){
            switch (step){
                case 1->{

                }
            }

        }

    }
}