package qa.hometest.productsinfo;

import io.restassured.response.Response;
import org.junit.Test;
import qa.hometest.model.ProductPojo;
import qa.hometest.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class PostProductTest extends TestBase {

    @Test
    public void logInToServiceAsAGivenUser() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setUsername("alice");
        productPojo.setPassword("a37d3106168770fa4477903703c548c7010ea570");

        Response response = given()
                .header("Authorization", "Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .body(productPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
    }

    @Test
    public void createANewProduct() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Lime Curd");
        productPojo.setAvailable(100);

        Response response = given()
                .when()
                .body(productPojo)
                .when()
                .post("/products");
        response.prettyPrint();
        response.then().statusCode(201);

    }

    @Test
    public void buyAnItemForTheCurrentlyLoggedInUser(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setUser_id(1);
        productPojo.setAmount(5);

      Response response = given()
                .header("id",1)
                .body(productPojo)
                .when()
                .post("/products/{id}");
      response.prettyPrint();
      response.then().statusCode(200);
    }


}
