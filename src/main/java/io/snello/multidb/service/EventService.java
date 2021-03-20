package io.snello.multidb.service;

import io.snello.api.DbService;
import io.snello.multidb.model.pojo.SimpleEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;

@ApplicationScoped
public class EventService {

    @Inject
    DbService dbService;

    Logger logger = Logger.getLogger(getClass());


    public void observe(@ObservesAsync SimpleEvent simpleEvent) throws Exception {
        logger.info(simpleEvent.toString());
        dbService.observe(simpleEvent);
    }
}
