package cn.edu.swu.hosuse;

import cn.edu.swu.db.DBEngine;
import cn.edu.swu.db.RecordVisitor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HouseRepo {

    private static HouseRepo instance = new HouseRepo();

    private HouseRepo(){
    }

    public static HouseRepo getInstance() {
        return instance;
    }

    public void saveHouse(House house) throws SQLException {
        if (house.getId() > 0) {
            this.updateHouse(house);
        } else {
            this.insertHouse(house);
        }
    }

    private void insertHouse(House house) throws SQLException {
        String template =
                "INSERT INTO `house`(`name`, `owner`, `ownerPhone`,`price`, `describe`, `picture`) " +
                        "VALUES (\"%s\", \"%s\", \"%s\",%s, \"%s\", \"%s\")";
        String sql = String.format(template, house.getName(), house.getOwner(), house.getOwnerPhone(),house.getPrice(), house.getDescribe(),house.getPicture());
        DBEngine.getInstance().execute(sql);
    }

    private void updateHouse(House house) throws SQLException {
        String template =
                "UPDATE `house` SET `name`=\"%s\", `owner`=\"%s\", `ownerPhone`=\"%s\",`price`=%s, `describe`=\"%s\" , `picture`=\"%s\"" +
                        "WHERE `id`=%s";
        String sql = String.format(template, house.getName(),
                house.getOwner(), house.getPrice(), house.getDescribe(), house.getPicture(),house.getId());
        DBEngine.getInstance().execute(sql);
    }

    public void deleteHouse(House house) throws SQLException {
        String template = "DELETE FROM `house` WHERE `id` = %s";
        String sql = String.format(template, house.getId());
        DBEngine.getInstance().execute(sql);
    }

    public void deleteHouse(Long id) throws SQLException {
        String template = "DELETE FROM `house` WHERE `id` = %s";
        String sql = String.format(template, id);
        DBEngine.getInstance().execute(sql);
    }

    public List<House> getAll() throws SQLException {
        String sql = "SELECT `id`, `name`, `owner`, `ownerPhone`,`price`, `describe`, `picture` FROM `house`";
        return DBEngine.getInstance().query(sql, new RecordVisitor<House>() {
            @Override
            public House visit(ResultSet rs) throws SQLException {
                return HouseRepo.getHouseFromResultset(rs);
            }
        });
    }

    public House getById(String id) throws SQLException {
        String sql = "SELECT * FROM `house` WHERE `id` = %s";
        List<House> houses = DBEngine.getInstance().query(
                String.format(sql, id), new RecordVisitor<House>() {
                    @Override
                    public House visit(ResultSet rs) throws SQLException {
                        return HouseRepo.getHouseFromResultset(rs);
                    }
                });
        return houses.size() == 0 ? null : houses.get(0);
    }


    private static House getHouseFromResultset(ResultSet rs) throws SQLException {
        House house = new House();
        house.setId(rs.getLong("id"));
        house.setName(rs.getString("name"));
        house.setOwner(rs.getString("owner"));
        house.setOwnerPhone(rs.getString("ownerPhone"));
        house.setDescribe(rs.getString("describe"));
        house.setPrice(rs.getFloat("price"));
        house.setPicture(rs.getString("picture"));
        return house;
    }

}