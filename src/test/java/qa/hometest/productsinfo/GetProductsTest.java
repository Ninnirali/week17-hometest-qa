package qa.hometest.productsinfo;

import io.restassured.response.Response;
import org.junit.Test;
import qa.hometest.model.ProductPojo;
import qa.hometest.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class GetProductsTest extends TestBase {

    @Test
    public void getAllProducts() {

        Response response = given().when().get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAProductById() {

        Response response = given()
                .pathParam("id", 1)
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
