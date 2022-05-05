import dbo.Student;
//import tables.CuratorTable;
import dbo.StudentGroup;
import tables.CuratorTable;
import tables.StudentGroupTable;
import tables.StudentTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String... args) {
//        showStudentsWithCurators();
//        showStudentsWomen();
//        countStudents();
        update();
    }

    public static void showStudentsWomen() {
        System.out.print("Girls:\n");
        Map<String, String> joins = new HashMap<>();
        joins.put("Student_Group", "student_group.id = student.id_group");
        joins.put("Curator", "curator.id = student_group.id_curator");

        List<String> where = new ArrayList<>();
//        where.add("sex = ''");

        List<Student> students = new StudentTable("mysql").list(where, joins);
        for (Student student : students) {
            System.out.printf(
                    "%s - %s - %s\n",
                    student.getFio(),
                    student.getGroup().getName(),
                    student.getGroup().getCurator().getFio()
            );
        }

        System.out.println();
    }

    public static void showStudentsWithCurators() {
        System.out.print("Students with curators:\n");
        Map<String, String> joins = new HashMap<>();
        joins.put("Student_Group", "student_group.id = student.id_group");
        joins.put("Curator", "curator.id = student_group.id_curator");

        List<String> where = new ArrayList<>();
//        where.add("sex = ''");

        List<Student> students = new StudentTable("mysql").list(where, joins);
        for (Student student : students) {
            System.out.printf(
                    "%s - %s - %s\n",
                    student.getFio(),
                    student.getGroup().getName(),
                    student.getGroup().getCurator().getFio()
            );
        }
        System.out.println();
    }

    public static void countStudents() {
        System.out.print("Count of students:\n");
        int studentsCount = new StudentTable("mysql").count();
        System.out.println(studentsCount);
        System.out.println();
    }

    //Обновить данные по группе сменив куратора
    public static void update(){
        System.out.print("Update:\n");
        String fieldName = "id_curator";
        int value = 1;
        List<String> where = new ArrayList<>();
        where.add("name = 'Group1'");
        new StudentGroupTable("mysql").update(fieldName, value, where);
        System.out.println("Success!");
    }
}
