package com.ticketweasel.users;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testRegisteringUser() {
        with()
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .body(new UserRecord(null, "Lemmy", "Kilminster", "lemmy@motorhead.com"))
                .post("/users/register")
                .then()
                .statusCode(201)
                .assertThat()
                .body("email", equalTo("lemmy@motorhead.com"));
    }

}
