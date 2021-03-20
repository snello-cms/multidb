package io.snello.multidb.repository.mysql;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Map;

@ConfigMapping(prefix = "snello.mysql")
public interface MysqlQueries {
    @WithName("queries")
    Map<String, String> queries();

}
