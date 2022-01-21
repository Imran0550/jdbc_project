package com.cydeo.jbdctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P02_FlexableNavigation {

    String dbUrl = "jdbc:oracle:thin:@34.192.175.227:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1() throws SQLException {
        // DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        // Create statement from Connection to runQueries
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // using with statement we will execute query
        ResultSet rs = statement.executeQuery("select first_name,last_name from employees");

        //first row
        rs.next();
        System.out.println(rs.getString(1) + "-"+rs.getString(2));

        //second row
        rs.next();
        System.out.println(rs.getString(1) + "-" + rs.getString(2));


        //last row
        rs.last();
        System.out.println(rs.getString(1) + "-" + rs.getString(2));

        /*
        ResultSet.TYPE_SCROLL_INSENSITIVE --> to be able to scroll your cursor or to jump directly in a certain row
        ResultSet.CONCUR_READ_ONLY --> we are saying I don't wanna change anything in database
         */
        int row = rs.getRow();

        //jump to row 8
        rs.absolute(8);
        row = rs.getRow();



        //close conn
        rs.close();
        statement.close();
        conn.close();

    }
}
