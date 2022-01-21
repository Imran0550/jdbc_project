package com.cydeo.jbdctests.day02;

import com.cydeo.jbdctests.utility.DB_Util;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class P02_BDUtilPractice {


    @Test
    public void task1(){
        //create connection
       DB_Util.createConnection();

       //run query

        DB_Util.runQuery("select first_name,last_name,salary,job_id from employees where ROWNUM <6");


        //Get all data as list of MAp
        List<Map<String,String>> allRowsAsListOfMap = DB_Util.getAllRowAsListOfMap();


        //print each row into screen

        for(Map<String,String> eachRow : allRowsAsListOfMap){
            System.out.println(eachRow);
        }


        //close connection
        DB_Util.destroy();
    }
}
