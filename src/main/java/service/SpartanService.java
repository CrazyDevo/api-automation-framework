package service;

import base.BaseService;
import io.restassured.response.Response;
import model.request.SpartanPatchRequest;
import utils.SpecBuilder;

import static io.restassured.RestAssured.given;

public class SpartanService extends BaseService {

    public Response getSpartanById(int id) {
        return get("/spartans/" + id);
    }

    public Response patchSpartan(int id, SpartanPatchRequest body) {
        return given()
                .spec(SpecBuilder.getRequestSpec())
                .body(body)
                .when()
                .patch("/spartans/" + id)
                .then()
                .extract()
                .response();
    }
}