package com.ticketweasel;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserRegistrationResourceTest {

    @Test
    public void testHelloEndpoint() {
        with().body(new UserRecord("Lemmy", "Kilminster", "lemmy@motorhead.com"))
                .post("/register")
                .then()
                .statusCode(201)
                .body(is("Hello from RESTEasy Reactive"));
    }

}
