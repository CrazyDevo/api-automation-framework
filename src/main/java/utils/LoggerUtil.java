package utils;

import io.restassured.filter.log.LogDetail;
import static io.restassured.RestAssured.filters;

public class LoggerUtil {

    public static void enableLogging() {
        filters(new io.restassured.filter.log.RequestLoggingFilter(LogDetail.ALL),
                new io.restassured.filter.log.ResponseLoggingFilter(LogDetail.ALL));
    }
}