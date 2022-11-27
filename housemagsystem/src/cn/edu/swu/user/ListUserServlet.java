package cn.edu.swu.user;

import cn.edu.swu.hosuse.House;
import cn.edu.swu.hosuse.HouseRepo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listUser")
public class ListUserServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<User> users =  UserRepo.getInstance().getAll();
            response.setContentType("text/html; charset=UTF-8");
            try(Writer writer = response.getWriter()) {
                writer.write("<center style=\"margin-top:5em\">\n");
                writer.write("<h1>欢迎访问我的网上书店</h1>\n");

                writer.write("<table width='55%' border='0' cellpadding=4>");
                for(int i = 0; i< users.size(); i++) {
                    User user = users.get(i);
                    if (i % 2 == 0) {
                        writer.write("<tr style='background-color:#F5F5F5;height:2em'>");
                    } else {
                        writer.write("<tr style='background-color:#D6E6F2;height:2em'>");
                    }
                    writer.write(String.format("<td width='150px'>%s</td>", user.getName()));
                    writer.write(String.format("<td width='100px'>%s</td>", user.getUser()));
                    writer.write(String.format("<td width='60px'>%s</td>", user.getPassword()));
                    writer.write(String.format("<td><a href='./deleteUser?id=%s'>" +
                            "<img src='./images/trash.png' width='20px'></a></td>", user.getId()));
                    writer.write(String.format("<td><a href='./updateUser?id=%s'>" +
                            "<img src='./images/edit.png' width='20px'></a></td>", user.getId()));
                    writer.write("</tr>");
                }
                writer.write("</table><br><br>\n\n");

                writer.write("<a href='index.html'>返 回 首 页</a>\n");
                writer.write("</center>\n");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
