package cn.edu.swu.hosuse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listHouse")
public class ListHouseServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<House> houses =  HouseRepo.getInstance().getAll();
            response.setContentType("text/html; charset=UTF-8");
            try(Writer writer = response.getWriter()) {
                writer.write("<center style=\"margin-top:5em\">\n");
                writer.write("<h1>欢迎访问网上房屋管理系统</h1>\n");

                writer.write("<table width='55%' border='0' cellpadding=4>");
                for(int i = 0; i< houses.size(); i++) {
                    House house = houses.get(i);
                    if (i % 2 == 0) {
                        writer.write("<tr style='background-color:#F5F5F5;height:2em'>");
                    } else {
                        writer.write("<tr style='background-color:#D6E6F2;height:2em'>");
                    }
                    writer.write(String.format("<td width='30px'>%s</td>", house.getId()));
                    writer.write(String.format("<td width='150px'>%s</td>", house.getName()));
                    writer.write(String.format("<td width='100px'>%s</td>", house.getOwner()));
                    writer.write(String.format("<td width='100px'>%s</td>", house.getOwnerPhone()));
                    writer.write(String.format("<td width='100px'>%s 万</td>", house.getPrice()));
                    writer.write(String.format("<td>%s</td>", house.getDescribe()));
                    writer.write(String.format("<td><img src='./upload/%s' style='width:50px'/></td>", house.getPicture()));
                    writer.write(String.format("<td><a href='./deleteHouse?id=%s'>" +
                            "<img src='./images/trash.png' width='20px'></a></td>", house.getId()));
                    writer.write(String.format("<td><a href='./updateHouse?id=%s'>" +
                            "<img src='./images/edit.png' width='20px'></a></td>", house.getId()));
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
