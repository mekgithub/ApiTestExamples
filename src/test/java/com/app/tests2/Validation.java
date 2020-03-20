package com.app.tests2;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class Validation {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://uinames.com/api/";
    }
    @Test
    public void test1(){
        //given prepare our request
        given().
                //when() is where we submit our request
                        //get() is our method in which ypu provide the end point or the url
                when().
                get().
                //then() is where you verify the response,any field in response,satatusCode etc.
                then().statusCode(200);
    }
    @Test
    public void test2(){
        //passing wrong url,verify if the status code is 404.
        given().
                when().
                get("8766").then().statusCode(404);
    }
    @Test
    public void headersTest(){
        given().
                when().get().
                then().log().headers().
                header("Content-Type","application/json; charset=utf-8");
        //validating headers and the firts parameter is to get the actual header and the second is the expected header
    }
    @Test
    public void testBody(){
        given().
                when().get().
                then().assertThat().body("name",notNullValue());
        //validate if the body has a field called name that is not null.
    }
    @Test
    public void testGender(){
        //want to verify if the names I get are female names.
        String gender="female";
        given().queryParam("gender",gender).
                when().get().
                then().log().body().assertThat().body("gender",is(gender));
    }
    @Test
    public void testRegion(){//we are creating  variable strig as a france,then i send my request with get(),i rece
        String region="France";
        given().
                queryParam("region",region).
                when().get().//we send our request
                then().log().body().//i received my response and log(print) my response,
                assertThat().body("region",is(region));
        //then I assert in that response payload do I have in the body field region as region
    }
    @Test
    public void testAmount(){
        given().queryParam("amount",4).
                when().get().
                then().log().body().
                assertThat().body("gender",hasSize(4));
    }
    @Test
    public void basicAuth(){
        given().
                auth().basic("path","path").
                when().get("https://httpbin.org/basic-auth/path/path").//I'm sending my request
                then().log().body();
    }
}
