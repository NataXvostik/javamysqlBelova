package db;

import java.sql.ResultSet;

public interface IDbExecutor {
    ResultSet execute(String sqlRequest);
    int update(String sqlRequest);
    void close();
}
