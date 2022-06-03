package qa.hometest.productsinfo;

import io.restassured.response.Response;
import org.junit.Test;
import qa.hometest.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class DeleteProductTest extends TestBase {

    @Test
    public void deleteAProductById() {
        Response response = given()
                .pathParam("id", 2)
                .when()
                .delete("/products/{id}")
                .then().extract().response();
        response.prettyPrint();
        response.then().statusCode(200);


    }


}
