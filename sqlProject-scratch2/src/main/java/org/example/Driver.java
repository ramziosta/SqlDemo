package org.example;

import org.example.models.User;
import org.example.repos.UserRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) {
        UserRepo userRepo = new UserRepo();

        // create a user
        //add user to db
        User ramzi = new User("ramzi", "osta", "email@email.com","password");
        User user1 = new User("Tiffany", "Obi", "tiffany.obi@revature.com", "password");
        User user2 = new User("Brandon", "Pinkerton", "brandom.pinkerton@revature.com", "password");
        User user4 = new User("Mojo", "Obi", "tiffany.gmail", "password");
        User user5 = new User("Bubbles", "Pinkerton", "brandom.gmailn@revature.com", "password");
        //     userRepo.create(ramzi);
    //int user4Id = userRepo.create(user4);
       // int user5Id = userRepo.create(user5);


        System.out.println(user4.toString());

    }
}

