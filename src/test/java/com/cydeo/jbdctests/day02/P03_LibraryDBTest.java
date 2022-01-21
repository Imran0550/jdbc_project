package com.cydeo.jbdctests.day02;

import com.cydeo.jbdctests.utility.DB_Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P03_LibraryDBTest {


    //Create connection
    String url = "jdbc:mysql://54.157.236.232:3306/library2";
    String username =  "library2_client";
    String password =  "6s2LQQTjBcGFfDhY" ;

    @Test
    public void testUserCount(){

        // Connection
        DB_Util.createConnection(url,username,password);

        // run query
        DB_Util.runQuery("select count(*) from users");

        //get result from DB

        String expectedData = DB_Util.getFirstRowFirstColumn();
        /*
        implement getting data from UI for user Count as dynamically
        Normally you need to type code here to get info about userCount
         */

        // get result from UI

        String actualData = "7358";

        // compare them

        Assertions.assertEquals(expectedData,actualData);

        DB_Util.destroy();
    }


    @Test
    public void testBookCount(){
        // create connection

        DB_Util.createConnection(url,username,password);

        //run query
        DB_Util.runQuery("select count(*) from books");

        //get result
        String actualBookCount = DB_Util.getFirstRowFirstColumn();


        //get UI result
        String expectCount = "23337";

        //compare them
        Assertions.assertEquals(expectCount,actualBookCount);

        DB_Util.destroy();
    }
}
