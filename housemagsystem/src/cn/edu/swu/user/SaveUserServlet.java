package cn.edu.swu.user;

import cn.edu.swu.hosuse.House;
import cn.edu.swu.hosuse.HouseRepo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        User  tmp = new User();
        tmp.setName(name);
        tmp.setUser(user);
        tmp.setPassword(password);
        System.out.println(String.format("%s, %s, %s", name,user,password));

        String message = null;
        try {
            UserRepo.getInstance().save(tmp);
            message = "提交信息保存成功！";
        } catch (SQLException e) {
            e.printStackTrace();
            message = "提交信息保存失败！";
        }

        response.setContentType("text/html; charset=UTF-8");
        try(Writer writer = response.getWriter()) {
            String html = "<center style=‘margin-top:5em’><h1>%s</h1><br><br>" +
                    "<a href='./submit-house.html'>再 次 录 入</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                    "<a href='./admin.html'>返 回 首 页</a>" +
                    "</center>";
            writer.write(String.format(html, message));
        }
    }

}
