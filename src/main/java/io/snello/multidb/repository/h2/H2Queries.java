package io.snello.multidb.repository.h2;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Map;

@ConfigMapping(prefix = "snello.h2")
public interface H2Queries {
     @WithName("queries")
     Map<String, String> queries();

}
