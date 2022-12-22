import service.CardService;
import service.P2PService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerStr=new Scanner(System.in);
        Scanner scannerInt=new Scanner(System.in);
        CardService cardService=new CardService();
        UserService userService=new UserService();
        P2PService p2PService=new P2PService();
      int stepcode=2;

      while (stepcode!=0){
          System.out.println("1 Add user 2 Login");
          stepcode= scannerStr.nextInt();
          switch (stepcode) {
              case 1->{
                  System.out.println("Entr username");
                  String username= scannerStr.nextLine();
                  System.out.println("Entr username");
                  String password= scannerInt.nextLine();
              }
              case 2->{

              }
          }
      }

    }
}