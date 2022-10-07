package com.revature.models;

public class FlashCard {
    int id;
    String question;
    String answer;
    int creator_id;

    public FlashCard() {
    }

    public FlashCard(String question, String answer, int creator_id) {

        this.question = question;
        this.answer = answer;
        this.creator_id = creator_id;
    }

    public FlashCard(int id, String question, String answer, int creator_id) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.creator_id = creator_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCreator_id() {
        return this.creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String toString() {
        return "FlashCard{id=" + this.id + ", question='" + this.question + '\'' + ", answer='" + this.answer + '\''
                + ", creator_id=" + this.creator_id + '}';
    }
}