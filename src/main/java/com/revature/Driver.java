package com.revature;

import com.revature.models.User;
import com.revature.models.FlashCard;
import com.revature.repos.FlashCardsRepo;
import com.revature.repos.UserRepo;

import java.util.List;


public class Driver {
    public static void main(String[] args) {
        UserRepo userRepo = new UserRepo();
        FlashCardsRepo flashCardRepo = new FlashCardsRepo();
        //creates newuser
//         User user11 =  new User ("Buttercup", "Powerpuff", "email555@powerpuff.com", "pwd");
        // int user11Id = userRepo.create(user11);
        // System.out.println(user11Id);

        //creates newflashcard
        // FlashCard fc2 = new FlashCard("what is this ", "this refers to this", 1);
//         flashCardRepo.create(fc2);

        //gets user by id
//        User user14fromDB = userRepo.getById(14);
//        System.out.println(user14fromDB.toString());

        //deletes user by id
//       boolean deletedUser = userRepo.delete(user14fromDB );
//        System.out.println(deletedUser);


                //gets flashcard by id
//        FlashCard flashCardDB = flashCardRepo.getById(8);
//        System.out.println(flashCardDB.toString());

        //deletes flashcard
//        boolean deletedFlashCard = flashCardRepo.delete(flashCardDB);
//        System.out.println(deletedFlashCard);

        //get user by id
//        User user1fromDB = userRepo.getById(1);
//        System.out.println(user1fromDB.getEmail());

        // sets new email, and updates email
//        user1fromDB.setEmail("ramziosta@gmail.com");
//        User updatedUser = userRepo.update(user1fromDB);
//        System.out.println(user1fromDB.getEmail());


                //get all users
//        List<User> dbUsers = userRepo.getAll();
//
//         for (User user: dbUsers) {
//             System.out.println(user.toString());
//          }

        //get all flashcards
//        List<FlashCard> dbFlashCards = flashCardRepo.getAll();
//
//        for (FlashCard flashcard: dbFlashCards) {
//            System.out.println(flashcard.toString());
//        }



        //gets flashcard by id
       FlashCard flashCardDB = flashCardRepo.getById(8);
//        System.out.println(flashCardDB.toString());

                    // UPDATES THE ANSWER ONLY!!!!!!!
              flashCardDB.setAnswer("OOP is Object Oriented programming");
               FlashCard updatedFlashCard = flashCardRepo.update(flashCardDB);
             System.out.println(flashCardDB.toString());

    }
}