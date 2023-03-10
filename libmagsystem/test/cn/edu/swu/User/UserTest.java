package cn.edu.swu.User;


import cn.edu.swu.user.User;
import cn.edu.swu.user.UserRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserTest {
    public static void main(String[] args) throws SQLException {
        User admin = new User();
        admin.setId(UUID.randomUUID().toString());
        admin.setName("管理员");
        admin.setUser("admin");
        admin.setPassword("swu.edu.cn");

        User guest = new User();
        guest.setId(UUID.randomUUID().toString());
        guest.setName("匿名用户");
        guest.setUser("guest");
        guest.setPassword("guest");

        UserRepo.getInstance().save(admin);
        UserRepo.getInstance().save(guest);

//        List<User> users = UserRepo.getInstance().getAll();
//        for (User user : users) {
//            System.out.println("删除" + user.getName());
//            UserRepo.getInstance().delete(user);
//        }
    }
}
