package org.senla.eu.client;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;

import static io.restassured.RestAssured.given;


@UtilityClass
public class RequestProvider {

    public static <T> T getRequest(RequestSpecification requestSpecification,
                                   ResponseSpecification responseSpecification,
                                   String path,
                                   Class<T> clazz) {
        Object obj;
        return
                given()
                        .spec(requestSpecification)
                        .basePath(path)
                .when()
                        .get()
                .then()
                        .spec(responseSpecification)
                        .extract()
                        .as(clazz);
}
    public static <T> T postAdminRequest(RequestSpecification requestSpecification,
                                         ResponseSpecification responseSpecification,
                                         String path,
                                         Object request,
                                         Class<T> clazz) {
        return
                given()
                        .spec(requestSpecification)
                        .basePath(path)
                        .body(request)
                .when()
                        .post()
                .then()
                        .spec(responseSpecification)
                        .extract()
                        .as(clazz);
    }
    public static <T> T postUserRequest(RequestSpecification requestSpecification,
                                        ResponseSpecification responseSpecification,
                                        String path,
                                        Class<T> clazz) {
        return
                given()
                        .spec(requestSpecification)
                        .basePath(path)
                .when()
                        .post()
                .then()
                        .spec(responseSpecification)
                        .extract()
                        .as(clazz);

    }
}
