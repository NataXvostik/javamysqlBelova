package dbo;

public class Student_Group {

    public final static String tableName = "Student group";

    public Student_Group(int id, String name, int idCurator) {

        this.id = id;
        this.name = name;
        this.idCurator = idCurator;
    }

    private int id;
    private String name;
    private int idCurator;

    public int getId() { return id; }

    public String getName() { return name; }

    public int idCurator() { return idCurator; }
}