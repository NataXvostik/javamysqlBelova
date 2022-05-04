package tables;

import dbo.Curator;
import dbo.Student;
import dbo.StudentGroup;
import utils.resources.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CuratorTable extends TableAbs<Curator> {

    private Curator curator;

    public CuratorTable(String dbType) {
        super(dbType);
    }

    @Override
    protected String getTableName() {
        return Curator.tableName;
    }

    @Override
    public List<Curator> list(List<String> predicate, Map<String, String> joinPredicates) {
        String query = DbUtils.getPredicate(predicate);
        String joins = DbUtils.getJoins(joinPredicates);

        if (predicate.isEmpty()) {
            query = String.format("SELECT * FROM %s %s", Student.tableName, joins);
        } else {
            query = String.format("SELECT * FROM %s %s WHERE %s ", Student.tableName, joins, query);
        }

        ResultSet resultSet = this.dbExecutor.execute(query);

        List<Curator> curators = new ArrayList<>();

        try {
            while (resultSet.next()) {
                curators.add(extractCurator(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return curators;
    }

    Curator extractCurator(ResultSet resultSet) throws SQLException {
        return new Curator(
                resultSet.getInt("curator.id"),
                resultSet.getString("curator.fio")
        );
    }
}
