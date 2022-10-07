package com.revature;

import com.revature.controllers.FlashCardController;
import com.revature.controllers.UserController;
import com.revature.services.FlashCardService;
import com.revature.services.UserService;
import io.javalin.Javalin;


public class Driver {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8081);
        UserService userService = new UserService();
        UserController userController = new UserController(userService);

        FlashCardService flashCardService = new FlashCardService();
        FlashCardController flashCardController = new FlashCardController(flashCardService);

        app.get("users", userController.getAllUsers);
        app.get("/user/{id}", userController.getUserById);
        app.post("/user", userController.createNewUser);
        app.put("/user", userController.updateUser);
        app.delete("/user", userController.deleteUser);

        app.get("flashcards", flashCardController.getAllFlashCards);
        app.get("/flashcard/{id}", flashCardController.getFlashCardById);
        app.post("/flashcard", flashCardController.createNewFlashCard);
        app.put("/flashcard", flashCardController.updateFlashCard);
        app.delete("/flashcard", flashCardController.deleteFlashCard);
    }
}