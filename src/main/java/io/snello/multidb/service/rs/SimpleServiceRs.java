package io.snello.multidb.service.rs;


import io.snello.api.DbService;
import io.snello.multidb.annotations.CustomerEventQualifier;
import io.snello.multidb.model.pojo.SimpleEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/multidb")
public class SimpleServiceRs {

    @ConfigProperty(name = "snello.dbtype")
    String dbtype;

    @Inject
    DbService dbService;

    @Inject
    Event<SimpleEvent> evvai;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        dbService.list();
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/event")
    public String event() throws Exception {
        evvai
                .select(new CustomerEventQualifier(dbtype))
                .fireAsync(new SimpleEvent("3333"));
        return "hello";
    }
}
