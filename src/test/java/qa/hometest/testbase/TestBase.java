package qa.hometest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import qa.hometest.utils.TestUtils;


public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;

    }
}
