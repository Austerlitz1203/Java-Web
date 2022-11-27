package cn.edu.swu.user;

import cn.edu.swu.db.DBEngine;
import cn.edu.swu.db.RecordVisitor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepo {

    private static UserRepo instance = new UserRepo();

    private UserRepo() {
    }

    public static UserRepo getInstance() {
        return instance;
    }

    public void save(User user) throws SQLException {
        if (user.getId() > 0) {
            this.updateUser(user);
        } else {
            this.insertUser(user);
        }
    }

    private void updateUser(User user) throws SQLException {
        String template =
                "UPDATE `user` SET `name`=\"%s\", `user`=\"%s\", `password`=\"%s\" " +
                        "WHERE `id`=%s";
        String sql = String.format(template, user.getName(),
                user.getUser(), user.getPassword());
        DBEngine.getInstance().execute(sql);
    }

    private void insertUser(User user) throws SQLException {
        String template =
                "INSERT INTO `user`(`name`, `user`, `password`) " +
                        "VALUES (\"%s\", \"%s\", \"%s\")";
        String sql = String.format(template, user.getName(), user.getUser(), user.getPassword());
        DBEngine.getInstance().execute(sql);
    }
    public User getById(String id) throws SQLException {
        String sql = "SELECT * FROM `user` WHERE `id` = %s";
        List<User> users = DBEngine.getInstance().query(
                String.format(sql, id), new RecordVisitor<User>() {
                    @Override
                    public User visit(ResultSet rs) throws SQLException {
                        return UserRepo.getUserByResultSet(rs);
                    }
                });
        return users.size() == 0 ? null : users.get(0);
    }

    public User auth(String user, String password) throws SQLException {
        String template = "SELECT * FROM `user` WHERE `user` = \"%s\" AND `password` = MD5(\"%s\")";
        List<User> users = DBEngine.getInstance().query(
                String.format(template, user, password), new RecordVisitor<User>() {
                    @Override
                    public User visit(ResultSet rs) throws SQLException {
                        return UserRepo.getUserByResultSet(rs);
                    }
                });
        return users.size() == 0 ? null : users.get(0);
    }

    public void deleteUser(User user) throws SQLException {
        String template = "DELETE FROM `user` WHERE `id` = \"%s\"";
        DBEngine.getInstance().execute(String.format(template, user.getId()));
    }
    public void deleteUser(Long id) throws SQLException {
        String template = "DELETE FROM `user` WHERE `id` = %s";
        String sql = String.format(template, id);
        DBEngine.getInstance().execute(sql);
    }

    public List<User> getAll() throws SQLException {
        String sql = "SELECT `id`, `name`, `user`, `password` FROM `user`";
        return DBEngine.getInstance().query(sql, new RecordVisitor<User>() {
            @Override
            public User visit(ResultSet rs) throws SQLException {
                return UserRepo.getUserByResultSet(rs);
            }
        });
    }

    private static User getUserByResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setUser(rs.getString("user"));
        user.setPassword(rs.getString("password"));
        return user;
    }

}