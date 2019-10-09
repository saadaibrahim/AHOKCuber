package controllers;

import com.auth0.jwt.algorithms.Algorithm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Path("/api/auth")
public class AuthenticationController {
    @GET
    @Path("/token")
    @Produces("application/json")
    public Response all() {
        //RSA
        Algorithm algorithmHS = Algorithm.HMAC256("secret");

        return Response.ok("clients list goes here", MediaType.APPLICATION_JSON).build();
    }
}
