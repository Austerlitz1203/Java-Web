package cn.edu.swu.db;

import cn.edu.swu.hosuse.House;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class dbtest {
    public static void main(String[] args) throws SQLException {
        DBEngine engine = DBEngine.getInstance();
        String sql = "SELECT `id`, `name`, `author`, `price`, `describe` from book";
        List<House> houses = engine.query(sql, new RecordVisitor<House>() {
            @Override
            public House visit(ResultSet rs) throws SQLException {
                House house = new House();
                house.setId(rs.getLong("id"));
                house.setName(rs.getString("name"));
                house.setOwner(rs.getString("author"));
                house.setPrice(rs.getFloat("price"));
                house.setDescribe(rs.getString("describe"));
                return house;
            }
        });

        for (House house : houses) {
            System.out.println(house.toString());
        }
    }
}
