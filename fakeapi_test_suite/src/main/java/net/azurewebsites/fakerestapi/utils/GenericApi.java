package net.azurewebsites.fakerestapi.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GenericApi {
    public Response post(String url, String body) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .post()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response put(String url, String body) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .put()
                .then().log().all()
                .extract()
                .response();
    }

    public Response get(String url) {
        return RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .log().all()
                .get(url)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response delete(String url) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .log().all()
                .delete(url)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
