import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basics {

    public static void main(String[] args) {
        //Declaring baseURI
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //Given block , queryParam if any , header , body , when, then , log all , status code validation,
        //status parameter validation and header validation
        given().log().all().queryParam("Key", "qaclick123").header("Content-type", "application/json")
                .body(requestBody.returnRequestBody()).
                when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
                .header("server", "Apache/2.4.18 (Ubuntu)");
    }
}
