//package tables;
//
//import dbo.Curator;
//import dbo.Student;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CuratorTable extends TableAbs {
//
//    private Curator curator;
//
//    public CuratorTable(String dbType) {
//        super(dbType);
//    }
//
//    @Override
//    public List<Curator> list() {
//        ResultSet resultSet = this.dbExecutor.execute(String.format("select * from %s", Curator.tableName));
//
//        List<Curator> curators = new ArrayList<>();
//
//        try {
//            while (resultSet.next()) {
//                curators.add(new Curator(
//                        resultSet.getInt(1),
//                        resultSet.getString(2)
//                ));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            this.dbExecutor.close();
//        }
//        return curators;
//    }}
