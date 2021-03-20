package io.snello.multidb.repository.producer;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.snello.api.DbService;
import io.snello.multidb.repository.h2.H2DbService;
import io.snello.multidb.repository.h2.H2Queries;
import io.snello.multidb.repository.mysql.MysqlDbService;
import io.snello.multidb.repository.mysql.MysqlQueries;
import io.snello.multidb.repository.postgresql.PostgresqlDbService;
import io.snello.multidb.repository.postgresql.PostgresqlQueries;
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

    @Inject
    @DataSource("h2")
    AgroalDataSource h2DataSource;

    @Inject
    H2Queries h2Queries;

    @Inject
    PostgresqlQueries postgresqlQueries;

    @Inject
    MysqlQueries mysqlQueries;

    public DbProducer() {
        System.out.println("DbProducer");
    }

    @Produces
    public DbService db() throws Exception {
        System.out.println("dbtype: " + dbtype);
        switch (dbtype) {
            case "mysql":
                return new MysqlDbService(mysqlDataSource, mysqlQueries.queries());
            case "postgresql":
                return new PostgresqlDbService(postgresqlDataSource, postgresqlQueries.queries());
            case "h2":
                return new H2DbService(h2DataSource, h2Queries.queries());
            default:
                throw new Exception("no dbtype");
        }
    }
}
