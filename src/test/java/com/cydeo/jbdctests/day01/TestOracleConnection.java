package com.cydeo.jbdctests.day01;

import java.sql.*;

public class TestOracleConnection {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@3.87.44.206:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        //DriverManager class getConnection method is used to make connection

        Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);

        //Create statement from connection to runQueries

       Statement statement = conn.createStatement();


       //using with statement we will execute query

       ResultSet resultSet = statement.executeQuery("select * from regions");


       //move cursor
        resultSet.next();


        //now we are first row w will get data
      //  System.out.println("rs.getString(\"region_name\") = " + resultSet.getString("region_name"));
       // System.out.println("rs.getString(2) = " + resultSet.getString());

        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString("region_name"));


        // 1 - Europe
        // 2 - Americas

        // second row
//        resultSet.next();
//
//        System.out.println(resultSet.getInt(1 + "-"+resultSet.getString(2)));
//
//        //third row
//        resultSet.next();
//
//        System.out.println(resultSet.getInt("region_id")+ "-"+resultSet.getString("region_name"));


        while (resultSet.next()){
            System.out.println(resultSet.getInt(1 )+ "-"+resultSet.getString(2));
        }


        //close connection

        resultSet.close();
        statement.close();
        conn.close();

    }
}
