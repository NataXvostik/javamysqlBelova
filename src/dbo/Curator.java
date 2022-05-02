package dbo;

public class Curator {

    public final static String tableName = "Curator";

    public Curator(int id, String fio) {

        this.id = id;
        this.fio = fio;
    }

    private String fio;
    private int id;

    public String getFio() {
        return fio;
    }

    public int getId() {
        return id;
    }
}
