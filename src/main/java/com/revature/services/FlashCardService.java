package com.revature.services;

import com.revature.models.FlashCard;
import com.revature.repos.FlashCardsRepo;
import java.util.List;



public class FlashCardService {

    private final FlashCardsRepo flashCardRepo;

    public FlashCardService(){
        flashCardRepo = new FlashCardsRepo();
    }

    public FlashCardService(FlashCardsRepo flashCardRepo){
        this.flashCardRepo = flashCardRepo;
    }


    //create
    public String create(FlashCard flashcard){
        if(flashCardRepo.create(flashcard) > 0 ){
            return " created";
        }
        return " not created";

        //return userRepo.create(user)

    }


    // read all
    public List<FlashCard> getAllFlashCards(){
        return flashCardRepo.getAll();
    }


    //read byID

    public FlashCard getById(int id){
        return flashCardRepo.getById(id);
    }

    //update

    public FlashCard update(FlashCard flashcard){
        return flashCardRepo.update(flashcard);
    }

    //delete
    public boolean deleteFlashCard(FlashCard flashcard){
        return flashCardRepo.delete(flashcard);
    }



}
