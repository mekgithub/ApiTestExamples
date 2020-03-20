package com.app.tests2;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Zamazingo {
@Test
    public void test1(){
    Response response= RestAssured.get("https://uinames.com/api/");
    response.prettyPrint();

    String responseAsstring=response.asString();

    Assert.assertTrue(responseAsstring.contains("name"));
    Assert.assertTrue(responseAsstring.contains("surname"));

    int actualStatiscode=response.statusCode();
    System.out.println(actualStatiscode);

    Assert.assertEquals(200,actualStatiscode);

    }
}
