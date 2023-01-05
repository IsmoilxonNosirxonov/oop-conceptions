package ui;

import ui.util.UtilScanner;

public class MainUi {
    public static void runMain(){
        while (true){
            System.out.println("1. login");
            System.out.println("0. stop");
            System.out.println("Choose one: ");
            String choose = UtilScanner.SCANNER_STR.nextLine();

            switch (choose){
                case "1"->AuthUi.login();
                case "0"->{
                    return;
                }
            }
        }
    }
}
