package com.ticketweasel.users;

import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @GET
    public Response get(@PathParam("id") Long id) {

        User user = (User) User.findById(id);
        if (user == null) {
            return Response.noContent().build();
        }else{
            UserRecord userRecord = new UserRecord(user.id, user.firstName, user.lastName, user.email);
            return Response.ok(userRecord).build();
        }
    }

    @POST
    @Path("/register")
    public Uni<Response> registerUser(UserRecord userRecord) {

        LOGGER.debug("Registering: {}", userRecord);
        User user = new User(userRecord.email(), userRecord.firstName(), userRecord.lastName());
        return user.persist().onItem().transform(u -> {
            return Response.created(URI.create("/users/" + ((User) u).id)).entity(user).build();
        });
    }


}
