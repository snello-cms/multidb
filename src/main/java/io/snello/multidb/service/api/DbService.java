package io.snello.multidb.service.api;

import java.util.List;
import java.util.Map;

public interface DbService {

     List<Map<String, Object>> list() throws Exception ;
     Map<String, Object> single() throws Exception ;
}
