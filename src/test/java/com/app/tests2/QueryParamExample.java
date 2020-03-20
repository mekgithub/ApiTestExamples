package com.app.tests2;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QueryParamExample {
  @BeforeClass
    public static void setUp(){
      RestAssured.baseURI="https://uinames.com/api/";
  }
  @Test
    public void uiNamesByAmount(){
      given().
              queryParam("amount","3").
              when().
              get().
              prettyPrint();
  }
  @Test
    public void uiNamesbyRegion(){
      given().
              queryParam("amount","5").
              queryParam("region","Turkey").
              when().
              get().
              prettyPrint();
  }
    @Test
    public void uiNamesbyAmountGenderRegion() {
        given().
                queryParam("amount", "3").
                queryParam("gender", "female").
                queryParam("region", "England").
                when().get().prettyPrint();
    }

}
