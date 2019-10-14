package controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import db.DBConnectionManager;
import models.Client;
import utils.Config;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/auth")
public class AuthenticationController {
    @POST
    @Path("/token")
    @Produces("application/json")
    public Response token() {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(Config.getProperty("AUTH_PASSPHRASE"));
            token = JWT.create()
                    .withIssuer("cuber")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return Response.ok(token, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(Client client) {
        DBConnectionManager.save(client);

        return Response.ok(client.toString(), MediaType.APPLICATION_JSON).build();
    }
}
