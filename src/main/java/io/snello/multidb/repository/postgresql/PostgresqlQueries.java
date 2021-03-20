package io.snello.multidb.repository.postgresql;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Map;

@ConfigMapping(prefix = "snello.postgresql")
public interface PostgresqlQueries {
    @WithName("queries")
    Map<String, String> queries();

}
