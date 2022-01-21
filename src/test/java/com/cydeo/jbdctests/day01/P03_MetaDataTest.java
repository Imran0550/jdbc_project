package com.cydeo.jbdctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class P03_MetaDataTest {

    @Test
    public void task1() throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@34.192.175.227:1521:XE";
        String dbUserName = "hr";
        String dbPassword = "hr";

        // DriverManager class getConnection method is used for make connection with DB
        Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        // Create statement from Connection to runQueries
        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // using with statement we will execute query
        ResultSet rs = statement.executeQuery("select * from regions ");

        // DataBase metaData --> Information about database


        DatabaseMetaData dbMetaData = conn.getMetaData();

        System.out.println(dbMetaData.getUserName());
        System.out.println(dbMetaData.getDatabaseProductName());
        System.out.println(dbMetaData.getDatabaseProductVersion());
        System.out.println(dbMetaData.getDriverName());
        System.out.println(dbMetaData.getDriverVersion());


        //ResultSrt MetaData

        ResultSetMetaData rsmd = rs.getMetaData();

        //how many cloumns we have
       int columns = rsmd.getColumnCount();
        System.out.println(columns);

        // how can we learn columnName for second column
        System.out.println(rsmd.getColumnName(2));


        // print all column names dynamically

        System.out.println("Dynamic print");
        for(int i=1;i<=columns;i++){
            System.out.println(rsmd.getColumnName(i));
        }



        while (rs.next()){


            for(int i=1;i<columns;i++){
                System.out.println(rsmd.getColumnName(i) + "-" + rs.getString(i));
            }
        }


        //close
        rs.close();
        statement.close();
        conn.close();

    }

    }
