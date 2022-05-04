package tables;

import dbo.Student;
import dbo.StudentGroup;
import utils.resources.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentGroupTable extends TableAbs<StudentGroup> {
    private CuratorTable curatorTable;
    private StudentGroup studentGroup;

    public StudentGroupTable(String dbType) {
        super(dbType);
        this.curatorTable = new CuratorTable(dbType);
    }

    @Override
    protected String getTableName() {
        return StudentGroup.tableName;
    }

    @Override
    public List<StudentGroup> list(List<String> predicate, Map<String, String> joinPredicates) {
        String query = DbUtils.getPredicate(predicate);
        String joins = DbUtils.getJoins(joinPredicates);

        if (predicate.isEmpty()) {
            query = String.format("SELECT * FROM %s %s", Student.tableName, joins);
        } else {
            query = String.format("SELECT * FROM %s %s WHERE %s ", Student.tableName, joins, query);
        }

        ResultSet resultSet = this.dbExecutor.execute(query);

        List<StudentGroup> studentGroup = new ArrayList<>();

        try {
            while (resultSet.next()) {
                studentGroup.add(this.extractStudentGroup(resultSet));
            }
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return studentGroup;
    }

    StudentGroup extractStudentGroup(ResultSet resultSet) throws SQLException {
        var curator = curatorTable.extractCurator(resultSet);
        StudentGroup studentGroup = new StudentGroup(
                resultSet.getInt("student_group.id"),
                resultSet.getString("student_group.name"),
                resultSet.getInt("student_group.id_curator"),
                curator
        );

        return studentGroup;
    }
}