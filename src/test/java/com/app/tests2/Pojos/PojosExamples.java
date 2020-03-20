package com.app.tests2.Pojos;

import com.google.gson.Gson;
import org.junit.Test;

public class PojosExamples {
    @Test
    public void test(){

        //serilization example
        Person person=new Person();
        person.setName("Jake");
        person.setSurname("Oconnor");
        person.setGender("male");
        person.setRegion("United States");

        System.out.println("printing person Java object: "+person);

        Gson gson=new Gson();

        String json=gson.toJson(person);
        System.out.println("printing json object: "+json);

        //deserilization
        //taking json object and conveerting into java object

        String myJonString="{\"name\":\"Maria\","+
                           "\"surname\":\"Oconnor\","+
                           "\"gender\":\"female\","+
                           "\"region\":\"United States\"}";
        Person myPerson=gson.fromJson(myJonString,Person.class);
        System.out.println("Printing new person java : "+myPerson);

    }
}

