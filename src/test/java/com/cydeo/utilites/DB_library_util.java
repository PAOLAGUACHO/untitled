package com.cydeo.utilites;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DB_library_util {

    public static Map<String,String> dataBaseBookInfo(String bookID){

        ResultSet resultSet = DB_util.executeQuery("select * from books where id='"+bookID+"'");
        Map<String,String> bookMap = new LinkedHashMap<>();

        try {
            resultSet.next();

            bookMap.put("id", resultSet.getString(1));
            bookMap.put("name", resultSet.getString(2));
            bookMap.put("isbn", resultSet.getString(3));
            bookMap.put("year", resultSet.getString(4));
            bookMap.put("author", resultSet.getString(5));
            bookMap.put("book_category_id", resultSet.getString(6));
            bookMap.put("description", resultSet.getString(7));
            bookMap.put("added_date", resultSet.getString(8));

        } catch (SQLException e) {
            System.out.println("Unable to load bookMap "+e.getMessage());
        }

        return bookMap;
    }
}
