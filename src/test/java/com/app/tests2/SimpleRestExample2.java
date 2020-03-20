package com.app.tests2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
//"https://uinames.com/api/"/
public class SimpleRestExample2 {
    @Test
    public void test1() {
        Response response=RestAssured.get("https://uinames.com/api/");
        response.prettyPrint();

        String responseAsstring=response.asString();
        Assert.assertTrue(responseAsstring.contains("name"));
        Assert.assertTrue(responseAsstring.contains("surname"));

        int responseActualStatusCode=response.statusCode();
        Assert.assertEquals(200,responseActualStatusCode);
        //System.out.println(responseActualStatusCode); bunu ben yazdim
    }
    @Test
    public void headersTest(){
        Response response=RestAssured.get("https://uinames.com/api/");
        String actualContentType=response.contentType();
        System.out.println(actualContentType);

        Assert.assertEquals("application/json; charset=utf-8",actualContentType);

    }
    @Test
    public  void statausLineTest(){
        Response response=RestAssured.get("https://uinames.com/api/");
        String statusLine=response.statusLine();
        System.out.println(statusLine);

        Assert.assertTrue(statusLine.contains("200"));
        Assert.assertTrue(statusLine.contains("OK"));
    }


}
