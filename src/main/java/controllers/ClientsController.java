package controllers;

import db.DBConnectionManager;
import models.Client;
import org.hibernate.Session;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// The Java class will be hosted at the URI path "/clients"
@Path("/clients")
public class ClientsController {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/")
    @Produces("application/json")
    public Response all() {
        // Return some cliched textual content
        return Response.ok(System.getProperty("user.dir"), MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response byId(@PathParam("id") String id) {
        if(id == null || id.trim().length() == 0) {
            return Response.serverError().entity("id cannot be blank").build();
        }
        return Response.ok("Your are requesting client (id => " + id + ")", MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/add")
    @Produces("application/json")
    public Response add() {
        // Return some cliched textual content
        Session session = DBConnectionManager.getSession();
        session.beginTransaction();

        Client client = new Client();
        client.setFirstname("asdasdasdas d asd asd asd");

        //Save the client in database
        session.save(client);

        //Commit the transaction
        session.getTransaction().commit();
        DBConnectionManager.closeConnection();

        return Response.ok(client, MediaType.APPLICATION_JSON).build();
    }
}