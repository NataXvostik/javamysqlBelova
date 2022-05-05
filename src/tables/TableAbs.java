package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;
import utils.resources.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public abstract class TableAbs<T> implements Itable<T> {

    protected IDbExecutor dbExecutor = null;

    public TableAbs(String dbType) {
        switch (dbType.toLowerCase(Locale.ROOT)) {
            case "mysql": {
                dbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }

    public int count() {
        ResultSet resultSet = dbExecutor.execute(String.format("SELECT COUNT(*) FROM %s", getTableName()));

        try {
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return -1;
    }

    protected abstract String getTableName();

    public void update(String fieldName, String value, List<String> predicate) {
        dbExecutor.execute(String.format("UPDATE %s SET %s = \"%s\" WHERE %s",
                getTableName(),
                fieldName,
                value,
                DbUtils.getPredicate(predicate)
        ));
    }

    public void update(String fieldName, int value, List<String> predicate) {
        dbExecutor.update(String.format("UPDATE %s SET %s = %d WHERE %s",
                getTableName(),
                fieldName,
                value,
                DbUtils.getPredicate(predicate)
        ));
    }
}