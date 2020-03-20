package com.app.tests2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class JsonPathExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://petstore.swagger.io/v2/";
    }
    @Test
    public void test(){

        Response response=RestAssured.given().pathParam("orderId","0").
                get("store/order/{orderId}");
        response.then().log().all().assertThat().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
        int id=jsonPath.get("id");
        System.out.println("printing pet order id : "+id);
        String shipDate=jsonPath.get("shipDate");
        System.out.println("printing pet order shipDate : "+ shipDate);
    }

    }
    /*
    {
    "id": 0,
    "petId": 0,
    "quantity": 0,
    "shipDate": "2020-01-20T13:40:02.204+0000",
    "status": "placed",
    "complete": true
}
     */

