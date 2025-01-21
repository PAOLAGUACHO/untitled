package com.cydeo.utilites;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DB_util {

    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;

    public static void connectToDatabase() {
        String url = ConfigurationReader.getProperty("library2.db.url");
        String user = ConfigurationReader.getProperty("library2.db.username");
        String password = ConfigurationReader.getProperty("library2.db.password");

        connectToDatabase(url, user, password);
    }



    public static void connectToDatabase(String url, String user, String password) {

        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

        } catch (SQLException e) {
            System.out.println("Failed to connect database " + e.getMessage());

        }
    }

    public static ResultSet executeQuery(String sql) {

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            rsmd = rs.getMetaData();

        } catch (SQLException e) {
            System.out.println("Failed to execute query " + e.getMessage());
        }

        return rs;
    }

    public static void closeConnection() {

        try{
            if (con != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection " + e.getMessage());
        }
    }

    public static Map<String,String> getDataTable(ResultSet rs) {

        Map<String,String> map = new LinkedHashMap<>();

        try {

            rs.next();

            for (int column = 1; column <= rs.getMetaData().getColumnCount(); column++) {
                for (int columnValue = 1; columnValue <= rs.getMetaData().getColumnCount(); columnValue++) {
                    map.put(rs.getMetaData().getColumnName(columnValue), rs.getString(columnValue));
                }
            }
        }catch (SQLException e) {
            System.out.println("Failed to get data table " + e.getMessage());
        }

        return map;
    }
}
