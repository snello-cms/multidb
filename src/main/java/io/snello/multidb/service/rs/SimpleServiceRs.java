package io.snello.multidb.service.rs;


import io.snello.api.DbService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/multidb")
public class SimpleServiceRs {

    @Inject
    DbService dbService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        dbService.list();
        return "hello";
    }
}
