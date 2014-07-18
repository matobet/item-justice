package com.matobet.itemjustice.rest;

import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Component
@Path("/hello")
public class SampleEndpoint {
    @GET
    public String message() {
        return "Hello Jersey";
    }

    @GET
    @Path("/{id}")
    public String getItem(@PathParam("id") String id) {
        return id;
    }
}
