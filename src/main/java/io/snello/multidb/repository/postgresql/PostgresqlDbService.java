package io.snello.multidb.repository.postgresql;

import io.agroal.api.AgroalDataSource;
import io.snello.api.DbService;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class PostgresqlDbService implements DbService {

    AgroalDataSource agroalDataSource;
    Map<String, String> queries;

    public PostgresqlDbService(AgroalDataSource agroalDataSource, Map<String, String> queries) {
        this.agroalDataSource = agroalDataSource;
        this.queries = queries;
        System.out.println("init PostgresqlDbService");
    }

    @Override
    public List<Map<String, Object>> list() throws Exception {
        try (Connection connection = agroalDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(this.queries.get("select-users"));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Object resul = resultSet.getObject(1);
                    if (resul != null) {
                        System.out.println("1");
                        return null;
                    }
                }
            }
        }
        System.out.println("postgresql list");
        return null;
    }

    @Override
    public Map<String, Object> single() throws Exception {
        System.out.println("postgresql single");
        return null;
    }
}
