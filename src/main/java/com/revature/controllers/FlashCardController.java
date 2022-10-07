package com.revature.controllers;

import com.revature.models.FlashCard;
import com.revature.services.FlashCardService;
import io.javalin.http.Handler;

public class FlashCardController {
    FlashCardService service;

    public FlashCardController() {
        service = new FlashCardService();
    }

    public FlashCardController(FlashCardService flashCardService) {
        service = flashCardService;
    }

    // create
    public Handler createNewFlashCard = context -> {

        FlashCard flashCard = context.bodyAsClass(FlashCard.class);
        int id = service.createFlashCard(flashCard);

        if (id > 0) {
            flashCard.setId(id);
            context.json(flashCard).status(200);
        } else {
            context.result("FlashCard not created").status(400);
        }
    };
    // get all flashCards
    public Handler getAllFlashCards = context -> {
        context.json(service.getAllFlashCards());
    };

    // id
    public Handler getFlashCardById = context -> {
        String param = context.pathParam("id");
        try {
            int id = Integer.parseInt(param);
            FlashCard flashCard = service.getFlashCardById(id);

            if (flashCard != null) {
                context.json(flashCard).status(200);
            } else {
                context.result("flashCard not found").status(400);
            }
        } catch (NumberFormatException nFMException) {
            System.out.println(nFMException.getMessage());
        }

    };

    // update

    public Handler updateFlashCard = context -> {

        FlashCard flashCard = context.bodyAsClass(FlashCard.class);
        flashCard = service.updateFlashCard(flashCard);

        if (flashCard != null) {
            context.json(flashCard).status(200);
        } else {
            context.result("FlashCard not updated").status(400);
        }
    };

    // delete

    public Handler deleteFlashCard = context -> {
        FlashCard flashCard = context.bodyAsClass(FlashCard.class);

        if (flashCard != null) {
            context.json(service.deleteFlashCard(flashCard)).status(200);
        } else {
            context.result("could not delete flashCard").status(400);
        }
    };

}
