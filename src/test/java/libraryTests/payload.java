package libraryTests;

public class payload {

    public static String addBookPayload(String isbn, String aisle) {
        return "{\n" +
                "    \"name\": \"Learn Appium Automation with Javascript\",\n" +
                "    \"isbn\": \"" + isbn + "\",\n" +
                "    \"aisle\": \"" + aisle + "\",\n" +
                "    \"author\": \"John lo\"\n" +
                "}";
    }
}
