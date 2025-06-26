package org.senla.eu.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;
import org.senla.eu.property.PropertyFile;

@UtilityClass
public class ApiConfig {

    public  RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(PropertyFile.getProperty("BASEURI"))
                .setAuth(RestAssured.basic(PropertyFile.getProperty("USERNAME"), PropertyFile.getProperty("PASSWORD")))
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public  ResponseSpecification responseSpecification() {

         final int successfulResponseCode = 200;
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(successfulResponseCode)
                .build();
    }

}
