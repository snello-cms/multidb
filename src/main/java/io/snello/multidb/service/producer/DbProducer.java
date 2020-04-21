package io.snello.multidb.service.producer;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.snello.multidb.service.api.DbService;
import io.snello.multidb.service.mysql.MysqlDbService;
import io.snello.multidb.service.postgresql.PostgresqlDbService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class DbProducer {

    @ConfigProperty(name = "snello.dbtype")
    String dbtype;

    @Inject
    @DataSource("mysql")
    AgroalDataSource mysqlDataSource;

    @Inject
    @DataSource("postgresql")
    AgroalDataSource postgresqlDataSource;

    public DbProducer() {
        System.out.println("DbProducer");
    }

    @Produces
    public DbService db() throws Exception {
        System.out.println("dbtype: " + dbtype);
        switch (dbtype) {
            case "mysql":
                return new MysqlDbService(mysqlDataSource);
            case "postgresql":
                return new PostgresqlDbService(postgresqlDataSource);
            default:
                throw new Exception("no dbtype");
        }
    }
}
