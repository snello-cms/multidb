package io.snello.multidb.repository.h2;

import io.agroal.api.AgroalDataSource;
import io.snello.api.DbService;
import io.snello.multidb.annotations.CustomerEvent;
import io.snello.multidb.model.pojo.SimpleEvent;
import org.jboss.logging.Logger;

import javax.enterprise.event.ObservesAsync;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class H2DbService implements DbService {

    Logger logger = Logger.getLogger(getClass());
    AgroalDataSource agroalDataSource;
    Map<String, String> queries;


    public H2DbService(AgroalDataSource agroalDataSource, Map<String, String> queries) {
        this.agroalDataSource = agroalDataSource;
        this.queries = queries;
        logger.info("init H2");
    }

    @Override
    public List<Map<String, Object>> list() throws Exception {
        try (Connection connection = agroalDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queries.get("select-users"));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Object resul = resultSet.getObject(1);
                    if (resul != null) {
                        logger.info("1");
                        return null;
                    }
                }
            }
        }
        logger.info("mysql list");
        return null;
    }

    @Override
    public Map<String, Object> single() throws Exception {
        logger.info("mysql single");
        return null;
    }

    @Override
    public void observe(@ObservesAsync @CustomerEvent("h2") SimpleEvent simpleEvent) throws Exception {
        logger.info(simpleEvent.toString());
    }
}
