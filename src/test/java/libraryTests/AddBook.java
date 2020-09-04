package libraryTests;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddBook {

    @Test(dataProvider = "addBookData")
    public void addBookApi(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String getBookResponse = given().log().all().header("Content-type", "application/json").body(payload.addBookPayload(isbn, aisle)).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath jsPath = new JsonPath(getBookResponse);
        String id = jsPath.getString("ID");
        System.out.println("Value of id is " + id);
    }

    @DataProvider(name = "addBookData")
    public Object[][] addBookTestData() {
        return new Object[][]{{"qazp", "123"}, {"wsxp", "456"}, {"edcp", "789"}};
    }
}
