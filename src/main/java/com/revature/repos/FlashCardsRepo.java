package com.revature.repos;


import com.revature.models.FlashCard;
import com.revature.utils.CRUDDaoInterface;
import com.revature.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FlashCardsRepo implements CRUDDaoInterface<FlashCard> {
    public Connection connection;

    public FlashCardsRepo() {
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=flashcard";
        String username = "postgres";
        String password = "Ac1bd2ce3@212";

        try {
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection.getSchema());
        } catch (SQLException sqlException) {

            System.out.println(sqlException.getMessage());
        }

    }


    // tested works fine
    @Override
    public int create(FlashCard flashcard) {
        String sql = "INSERT INTO flashcards (id, question, answer, creator_id) VALUES(default,?,?,?); ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, flashcard.getQuestion());
            pstmt.setString(2, flashcard.getAnswer());
            pstmt.setInt(3, flashcard.getCreator_id());


            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt("id");

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    // tested works fine
    @Override
    public List<FlashCard> getAll() {

        List<FlashCard> flashcards = new ArrayList<>();

        try {
            String sql = "SELECT * FROM flashcards";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                FlashCard flashcard = new FlashCard();

                flashcard.setId(rs.getInt("id"));
                flashcard.setQuestion(rs.getString("question"));
                flashcard.setAnswer(rs.getString("answer"));
                flashcard.setCreator_id(rs.getInt("creator_id"));

                flashcards.add(flashcard);
            }

            return flashcards;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

  // tested works fine
    @Override
    public FlashCard getById(int id) {

        try {
            String sql = "SELECT * FROM flashcards WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            // Returns a flashcard therefore a new instance of a flashcard from database has to be created
            FlashCard flashcard = new FlashCard();

            while (rs.next()){
                flashcard.setId(rs.getInt("id"));
                flashcard.setQuestion(rs.getString("question"));
                flashcard.setAnswer(rs.getString("answer"));

            }

            return flashcard;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }


// tested works fine
    //THIS ONLY UPDATES THE ANSWER!!!!
    @Override
    public FlashCard update(FlashCard flashCard) {

        try {

            String sql = "UPDATE flashcards SET answer = ? WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, flashCard.getAnswer());
            pstmt.setInt(2, flashCard.getId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                flashCard.setAnswer(rs.getString("answer"));
            }

            return flashCard;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());


        }
        return null;
    }


    //tested works fine
    @Override
    public boolean delete(FlashCard flashcard) {
        try {
            String sql = "DELETE FROM flashcards WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, flashcard.getId());
            ResultSet rs = pstmt.executeQuery();
            return true;


        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return false;
    }
}


