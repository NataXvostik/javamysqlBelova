package dbo;

public class Student {

   public final static String tableName = "Student";

    public Student(int id, String fio, String sex, StudentGroup group) {

        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.group = group;
    }
    private int id;
    private String fio;
    private String sex;
    private StudentGroup group;

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }

    public StudentGroup getGroup() {
        return group;
    }
}
