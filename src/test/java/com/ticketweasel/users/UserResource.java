package com.ticketweasel.users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {


    @GET
    public Response get(@PathParam("id") Long id) {

        User user = (User) User.findById(id);
        if (user == null) {
            return Response.noContent().build();
        }else{
            UserRecord userRecord = new UserRecord(user.firstName, user.lastName, user.email);
            return Response.ok(userRecord).build();
        }
    }

}
