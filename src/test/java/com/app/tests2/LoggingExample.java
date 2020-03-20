package com.app.tests2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoggingExample {
    @Test
    public void logging(){
        given().log().all().
                when().get("https://api.got.show/api/show/animals/");
        System.out.println("****************************************");
        given().log().method().
                when().get("https://api.got.show/api/show/animals/");
        System.out.println("****************************************");
        given().log().body().
                when().get("https://api.got.show/api/show/animals/");
    }
    @Test
    public void loggingResponse(){
        Response response= RestAssured.get("https://uinames.com/api/");
        response.then().log().all();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        response.then().log().body();
    }
}
