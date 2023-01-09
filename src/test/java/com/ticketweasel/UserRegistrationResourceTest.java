package com.ticketweasel;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserRegistrationResourceTest {

    public void testHelloEndpoint() {
        with().body(new UserRecord("Lemmy", "Kilminster", "lemmy@motorhead.com"))
                .post("/register")
                .then()
                .statusCode(201)
                .body(is("Hello from RESTEasy Reactive"));
    }

}
