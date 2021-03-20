package io.snello.multidb.repository.mysql;

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

public class MysqlDbService implements DbService {

    Logger logger = Logger.getLogger(getClass());
    AgroalDataSource agroalDataSource;
    Map<String, String> queries;

    public MysqlDbService(AgroalDataSource agroalDataSource, Map<String, String> queries) {
        this.agroalDataSource = agroalDataSource;
        this.queries = queries;
        logger.info("init MysqlDbService");
    }

    @Override
    public List<Map<String, Object>> list() throws Exception {
        try (Connection connection = agroalDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(this.queries.get("select-users"));
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
    public void observe(@ObservesAsync @CustomerEvent("mysql")  SimpleEvent simpleEvent) throws Exception {
        logger.info(simpleEvent.toString());
    }
}
