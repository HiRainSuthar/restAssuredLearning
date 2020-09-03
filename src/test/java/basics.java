import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basics {

    public static void main(String[] args) {
        //Declaring baseURI
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //Given block , queryParam if any , header , body , when, then , log all , status code validation,
        //status parameter validation and header validation
        String response = given().log().all().queryParam("Key", "qaclick123").header("Content-type", "application/json")
                .body(requestBody.returnRequestBody()).
                when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
                .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
        //printing extracted response
//        System.out.println("response is "+ response);
        //Using jsonpath parsing json
        JsonPath jpath  = new JsonPath(response);
        String placeId = jpath.getString("place_id");
        System.out.println("value of place_Id is "+ placeId);
    }
}
