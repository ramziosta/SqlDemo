package com.revature.services;

import com.revature.models.FlashCard;
import com.revature.repos.FlashCardsRepo;
import java.util.List;

public class FlashCardService {

    private final FlashCardsRepo flashCardRepo;

    public FlashCardService() {
        flashCardRepo = new FlashCardsRepo();
    }

    public FlashCardService(FlashCardsRepo flashCardRepo) {
        this.flashCardRepo = flashCardRepo;
    }

    // create
    public int createFlashCard(FlashCard flashcard) {

        return flashCardRepo.create(flashcard);

    }

    // read all
    public List<FlashCard> getAllFlashCards() {
        return flashCardRepo.getAll();
    }

    // read byID

    public FlashCard getFlashCardById(int id) {
        return flashCardRepo.getById(id);
    }

    // update

    public FlashCard updateFlashCard(FlashCard flashcard) {
        return flashCardRepo.update(flashcard);
    }

    // delete
    public boolean deleteFlashCard(FlashCard flashcard) {
        return flashCardRepo.delete(flashcard);
    }

    public boolean deleteFlashCardById(int id) {
        return flashCardRepo.deleteById(id);
    }

}
