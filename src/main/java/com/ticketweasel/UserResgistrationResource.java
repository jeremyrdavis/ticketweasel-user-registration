package com.ticketweasel;

import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/register")
@Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
public class UserResgistrationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResgistrationResource.class);

    @POST
    public Uni<Response> registerUser(UserRecord userRecord) {

        LOGGER.debug("Registering: {}", userRecord);
        User user = new User(userRecord.email(), userRecord.firstName(), userRecord.lastName());
        return user.persist().onItem().transform(u -> {
            return Response.created(URI.create("/users/" + ((User) u).id)).build();
        });
    }
}
