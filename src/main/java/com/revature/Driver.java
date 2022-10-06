package com.revature;

import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.models.FlashCard;
import com.revature.repos.FlashCardsRepo;
import com.revature.repos.UserRepo;
import com.revature.services.UserService;
import io.javalin.Javalin;

import java.util.List;


public class Driver {
    public static void main(String[] args) {


        Javalin app = Javalin.create().start(8081);
        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        app.get("users", userController.getAllUsers);
        app.get("/user/{id}", userController.getUserById);
        app.post("/user", userController.createNewUser);
        app.put("/user", userController.updateUser);
        app.delete("/user", userController.deleteUser);
    }
}