package org.example.utils;
import java.util.List;

public interface CRUDDaoInterface<T> {

    // DAO - Data Access Object
    //  a pattern that provides an abstract interface to some type of database
    // or other persistence mechanism

    // Returns a primary key of this newly added row
    int create(T t);

    // Select all for a table = SELECT * From Table in SQL
    List<T> getAll();

    // Retrieve a record by id = SELECT Id
    T getById(int id);

    // Update a record = UPDATE record
    T update(T t);

    // Delete a record = DELETE FROM
    boolean delete(T t);

}