package tables;

import db.IDbExecutor;
import db.MySqlDbExecutor;
import dbo.Student;

import java.util.Locale;

public abstract class TableAbs implements Itable<Student>{

    protected IDbExecutor dbExecutor = null;

    public TableAbs(String dbType){
        switch (dbType.toLowerCase(Locale.ROOT)){
            case "mysql":{
                dbExecutor = new MySqlDbExecutor();
                break;
            }
        }
    }
}
