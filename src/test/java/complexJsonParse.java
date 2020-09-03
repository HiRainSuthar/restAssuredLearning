import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class complexJsonParse {
    /*
    1. Print No of courses returned by API
2.Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount
     */

    public static void main(String[] args) {
        JsonPath jsPath = new JsonPath(mockResponse.returnMockResponse());
        //1. Print No of courses returned by API
        int courseSize = jsPath.getInt("courses.size()");
        System.out.println("value of courseSize is >> "+ courseSize);

        //2.Print Purchase Amount
        int purchaseAmount = jsPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchase amount is >> "+ purchaseAmount);

        //3. Print Title of the first course
        String firstCourseTitle = jsPath.getString("courses[0].title");
        System.out.println("value of first course title is >> "+ firstCourseTitle);

        //4. Print All course titles and their respective Prices
        for (int i = 0; i< courseSize; i++) {
            System.out.println("value of "+i+" course title is >> "+ jsPath.getString("courses["+i+"].title"));
            System.out.println("value of "+i+" course price is >> "+ jsPath.getString("courses["+i+"].price"));
        }

        //5. Print no of copies sold by RPA Course
        int copiesSoldRPA = jsPath.getInt("courses[2].copies");
        System.out.println("value of copies sold by RPA Cour >> "+ copiesSoldRPA);

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int total = 0;
        for (int i = 0; i< courseSize; i++) {
            total = total + jsPath.getInt("courses["+i+"].price") *  jsPath.getInt("courses["+i+"].copies");

        }
        System.out.println("Value of total is "+ total);
        Assert.assertEquals(purchaseAmount, total);
    }
}
