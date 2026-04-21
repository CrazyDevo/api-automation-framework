package tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.request.SpartanPatchRequest;
import model.response.SpartanResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import service.SpartanService;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Spartan API")
public class SpartanTests extends BaseTest {

    SpartanService service = new SpartanService();

    @Test
    @Tag("smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Description("GET Spartan by ID - Positive")
    void getSpartanById_positive() {

        Response response = service.getSpartanById(15);

        // JSONPath
        assertEquals(200, response.statusCode());
        assertEquals("Meta", response.jsonPath().getString("data.name"));


        /*
        seri----> java to json
        deseri ----> json to java


         */

        // POJO
        SpartanResponse spartan =
                response.as(SpartanResponse.class);



        assertEquals("Meta", spartan.data.name);
    }

    @Test
    @Tag("regression")
    @Severity(SeverityLevel.NORMAL)
    @Description("GET Spartan by ID - Negative (404)")
    void getSpartanById_negative() {

        Response response = service.getSpartanById(9999);

        assertEquals(404, response.statusCode());
    }


    @Test
    @Tag("regression")
    @Severity(SeverityLevel.CRITICAL)
    @Description("PATCH Spartan - Update name and phone")
    void patchSpartanTest() {

        // GIVEN
        SpartanPatchRequest request =
                new SpartanPatchRequest("Leonidas", "1234567890");

        // WHEN
        Response response = service.patchSpartan(15, request);

        // THEN
        assertEquals(200, response.statusCode());

        // VERIFY WITH GET
        Response getResponse = service.getSpartanById(12);

        JsonPath json = getResponse.jsonPath();
        assertEquals("Leonidas", json.getString("data.name"));
        assertEquals("1234567890", json.getString("data.phone"));
    }



}