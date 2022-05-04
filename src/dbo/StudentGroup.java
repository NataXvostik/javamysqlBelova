package dbo;

public class StudentGroup {

    public final static String tableName = "Student_group";

    public StudentGroup(int id, String name, int idCurator, Curator curator) {
        this.id = id;
        this.name = name;
        this.idCurator = idCurator;
        this.curator = curator;
    }

    private int id;
    private String name;
    private int idCurator;
    private Curator curator;

    public int getId() { return id; }

    public String getName() { return name; }

    public int idCurator() { return idCurator; }

    public Curator getCurator() {
        return curator;
    }
}