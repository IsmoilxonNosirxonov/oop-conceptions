package click.client.UI;

import click.client.Util.ScannerUtil;

public class MainUI {
    public static void mainWindow() {
        while (true){
            String choose = chooseOperation();

            switch (choose){
                case "1" -> AuthUI.signIn();
                case "2" -> AuthUI.signUp();
                case "0" -> {
                    return;
                }
            }
        }
    }

    private static String chooseOperation() {
        System.out.println("\n1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("0. Exit");
        System.out.print("\nChoose one: ");
        return ScannerUtil.scanner.nextLine();
    }

}
