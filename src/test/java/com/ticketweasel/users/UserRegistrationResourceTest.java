package com.ticketweasel.users;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;

@QuarkusTest
public class UserRegistrationResourceTest {

    @Test
    public void testHelloEndpoint() {
        with()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body(new UserRecord("Lemmy", "Kilminster", "lemmy@motorhead.com"))
                .post("/register")
                .then()
                .statusCode(201)
                .body("$", hasItems("email", "firstName", "lastName"));
    }

}
