package tests;

import base.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
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
}