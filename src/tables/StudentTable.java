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

public class StudentTable extends TableAbs<Student> {

    private final StudentGroupTable studentGroupTable;

    public StudentTable(String dbType) {
        super(dbType);
        this.studentGroupTable = new StudentGroupTable(dbType);
    }

    @Override
    protected String getTableName() {
        return Student.tableName;
    }

    @Override
    public List<Student> list(List<String> predicate, Map<String, String> joinPredicates) {
        String query = DbUtils.getPredicate(predicate);
        String joins = DbUtils.getJoins(joinPredicates);

        if (predicate.isEmpty()) {
            query = String.format("SELECT * FROM %s %s", Student.tableName, joins);
        } else {
            query = String.format("SELECT * FROM %s %s WHERE %s ", Student.tableName, joins, query);
        }

        ResultSet resultSet = this.dbExecutor.execute(query);
        List<Student> students = new ArrayList<>();

        try {
            while (resultSet.next()) {
                StudentGroup studentGroup = this.studentGroupTable.extractStudentGroup(resultSet);
                students.add(new Student(
                        resultSet.getInt("student.id"),
                        resultSet.getString("student.fio"),
                        resultSet.getString("student.sex"),
                        studentGroup
                ));
            }
        } catch (
                SQLException ex) {
            ex.printStackTrace();
        } finally {
            this.dbExecutor.close();
        }
        return students;
    }
}
