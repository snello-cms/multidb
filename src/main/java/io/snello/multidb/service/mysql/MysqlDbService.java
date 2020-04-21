package io.snello.multidb.service.mysql;

import io.agroal.api.AgroalDataSource;
import io.snello.multidb.service.api.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class MysqlDbService implements DbService {

    AgroalDataSource agroalDataSource;

    public MysqlDbService(AgroalDataSource agroalDataSource) {
        this.agroalDataSource = agroalDataSource;
        System.out.println("init MysqlDbService");
    }

    @Override
    public List<Map<String, Object>> list() throws Exception {
        try (Connection connection = agroalDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select 1");
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
        System.out.println("mysql list");
        return null;
    }

    @Override
    public Map<String, Object> single() throws Exception {
        System.out.println("mysql single");
        return null;
    }
}
