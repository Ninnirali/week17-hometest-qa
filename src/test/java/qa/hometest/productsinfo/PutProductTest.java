package qa.hometest.productsinfo;

import io.restassured.response.Response;
import org.junit.Test;
import qa.hometest.model.ProductPojo;
import qa.hometest.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class PutProductTest extends TestBase {

    @Test
    public void updateAProductByItsId() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setId(4);
        productPojo.setName("Lime curd5");
        productPojo.setAvailable(150);
        Response response = given()
                .header("Authorization","Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .pathParam("id", 1)
                .body(productPojo)
                .when()
                .put("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }


}
