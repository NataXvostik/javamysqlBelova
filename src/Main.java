import dbo.Curator;
import dbo.Student;
//import tables.CuratorTable;
import tables.StudentTable;

import java.util.List;

public class Main {

    public static void main(String... args) {
        List<Student> students = new StudentTable("mysql").list();

        for (Student student : students) {
            System.out.println(student.getFio());
        }

//        List<Student> curators = new CuratorTable("mysql").list();
//
//        for (Student curator : curators) {
//            System.out.println(curator.
//        }

    }
}
