package com.app.tests2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class WarmUp {
    @Test
    public void warmUp(){
        Response response= RestAssured.get("https://api.got.show/api/show/animals/");
        response.prettyPrint();
         String responseAsstring=response.asString();
        Assert.assertTrue(responseAsstring.contains("habitat"));

        int actuaStatusCode=response.statusCode();
        Assert.assertEquals(200,actuaStatusCode);
    }
}
