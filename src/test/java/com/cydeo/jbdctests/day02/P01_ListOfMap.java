package com.cydeo.jbdctests.day02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P01_ListOfMap {

    String dbUrl = "jdbc:oracle:thin:@34.192.175.227:1521:XE";
    String dbUserName = "hr";
    String dbPassword = "hr";

    @Test
    public void task1(){
        Map<String,Object> rowMap1 = new HashMap<>();

        rowMap1.put("first_name","Steven");
        rowMap1.put("last_name","King");
        rowMap1.put("Salary",24000);

        System.out.println("rowmap1 = "+ rowMap1);

        Map<String,Object> rowMap2 = new HashMap<>();
        rowMap2.put("first_name","Neena");
        rowMap2.put("last_name","Kochhar");
        rowMap2.put("salary",17000);


        System.out.println( "rowMap2 = "+ rowMap2);


        /**
         *
         *
         * it will keep continue until all the way down to table
         *
         */

        List<Map<String,Object>> list = new ArrayList<>();

        list.add(rowMap1);
        list.add(rowMap2);

        // Give me lastname of Steven

        System.out.println(list.get(0).get("last_name"));


    }
}
