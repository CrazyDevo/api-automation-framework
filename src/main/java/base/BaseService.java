package base;

import io.restassured.response.Response;
import utils.SpecBuilder;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected Response get(String endpoint) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .get(endpoint)
                .then()
                .spec(SpecBuilder.getResponseSpec())
                .extract()
                .response();
    }
}