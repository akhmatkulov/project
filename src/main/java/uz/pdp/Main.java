package uz.pdp;

import uz.pdp.model.User;
import uz.pdp.service.UserService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.register(new User(UUID.randomUUID(),"Sardor","Norboyev","sardor0304",21,"123"));
        userService.register(new User(UUID.randomUUID(),"Sardor","Norboyev","sardor0304",21,"123"));
    }
}