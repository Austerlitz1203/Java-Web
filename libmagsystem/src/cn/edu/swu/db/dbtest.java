package cn.edu.swu.db;

import java.sql.SQLException;

public class dbtest {
    public static void main(String[] args) throws SQLException {
        DBEngine dbEngine=DBEngine.getInstance();
        String sql="delete from book where id=6";
        dbEngine.execute(sql);
    }
}
