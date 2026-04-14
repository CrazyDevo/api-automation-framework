package service;

import base.BaseService;
import io.restassured.response.Response;

public class SpartanService extends BaseService {

    public Response getSpartanById(int id) {
        return get("/spartans/" + id);
    }
}