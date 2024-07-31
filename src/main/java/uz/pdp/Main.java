package uz.pdp;

import uz.pdp.model.User;
import uz.pdp.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
   static Scanner scannerStr = new Scanner(System.in);
   static Scanner scannerInt = new Scanner(System.in);
   static UserService userService = new UserService();

    public static void main(String[] args) {
        int step = 10;
        while (step != 0) {
            System.out.println("\u001B[34m1.Register:  2.Login:\u001B[0m");
            try {
                step = scannerInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mYou enter incorrect type argument.\u001B[0m");
                scannerInt.next();
            }
            if (step == 1) {
                register();
            } else if (step == 2) {
                login();
            }
        }
    }

    private static void register() {
        System.out.print("\u001B[34mEnter firstname:\u001B[0m ");
        String firstname = scannerStr.nextLine();
        System.out.print("\u001B[34mEnter lasttname:\u001B[0m ");
        String lastname = scannerStr.nextLine();
        System.out.print("\u001B[34mEnter username:\u001B[0m ");
        String username = scannerStr.nextLine();
        System.out.print("\u001B[34mEnter password:\u001B[0m ");
        String password = scannerStr.nextLine();
        System.out.print("\u001B[34mEnter age:\u001B[0m ");
        int age = scannerInt.nextInt();
        User user = userService.register(new User(UUID.randomUUID(),firstname,lastname, username, age, password));
        if (user != null) {
            System.out.println("\u001B[31mThis user successfully registered\u001B[0m");
        } else {
            System.out.println("\u001B[31mThis user not found!\u001B[0m");
        }
    }

    private static void login() {
        System.out.print("\u001B[34mEnter username:\u001B[0m ");
        String username = scannerStr.nextLine();
        System.out.print("\u001B[34mEnter password:\u001B[0m ");
        String password = scannerStr.nextLine();
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("\u001B[38mWelcome!\u001B[0m");
        } else {
            System.out.println("\u001B[31mThis user not found!\u001B[0m");
        }
    }
}
