package cn.edu.swu.hosuse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/updateHouse")
public class UpdateHouseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        House house = new House();
        try {
            house = HouseRepo.getInstance().getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>My Book Store</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <center>\n" +
                "    <div style=\"margin-top:5em; padding: 2em;text-align:center; width:60%; background-color:#EEEEEE\">\n" +
                "      <h2>编辑房源信息</h2>\n" +
                "      <form action=\"./saveHouse\" method=\"post\">\n" +
                "        <input type=\"hidden\" name=\"id\" value=\"" + house.getId() + "\"><br><br>\n" +
                "        房 名： <input type=\"text\" name=\"name\" value=\"" + house.getName() + "\"><br><br>\n" +
                "        拥 有 者： <input type=\"text\" name=\"author\" value=\"" + house.getOwner() + "\"><br><br>\n" +
                "        电 话： <input type=\"text\" name=\"ownerPhone\" value=\"" + house.getOwnerPhone() + "\"><br><br>\n" +
                "        价 格： <input type=\"text\" name=\"price\" value=\"" + house.getPrice() + "\"><br><br>\n" +
                "        简 介： <textarea name=\"describe\" rows=\"4\" cols=\"22\">" + house.getDescribe() + "</textarea> <br><br>\n" +
                //"        图 片： <input type=\"file\" name=\"picture\" value=\"" + house.getPicture() + "\"><br><br>\n" +
                "        <input type=\"submit\" value=\" 提 交 信 息\">\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </center>\n" +
                "</body>\n" +
                "</html>";

        response.setContentType("text/html; Charset=utf8");
        try(Writer writer = response.getWriter()) {
            writer.write(html);
        }
    }

}
