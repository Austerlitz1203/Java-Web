package cn.edu.swu;

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

@WebServlet("/index.html")
public class Index extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<House> houses = null;
        try {
            houses = HouseRepo.getInstance().getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<br><div class='book-group'>\n");
        for (House house : houses) {
            sb.append("<div class='book-div'>");
            sb.append("<div class='book-pic'><img src=\"./images/b11.png\"/></div>");
            sb.append("<div class='book-name'>" + house.getName() + "</div>");
            sb.append("<div class='book-author'>拥有者: " + house.getOwner() + "</div>");
            sb.append("<div class='book-price'>价格：" + house.getPrice()+ "万</div>");
            sb.append("</div>\n");
        }
        sb.append("</div><br>\n");

        String page = "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>My Java Web APP</title>\n" +
                "        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">" +
                "    </head>\n" +
                "    <body>\n" +
                "        <center style=\"margin-top:1em\">\n" +
                "            <h1>欢迎访问网上房屋系统</h1>\n" +
                "            <div style=\"margin-top:2em; width: 50%\">\n" +
                "                <div>\n" +
                "                    <div style=\"float:left;padding-right:3em\"><a href=\"./listHouse\">查看房源</a></div>\n" +
                "                </div>\n" +
                "                <div>\n" +
                "                    <div style=\"float:left;padding-right:3em\"><a href=\"./login\">登录后台</a></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <br><hr width='80%'>\n" +
                "          "  + sb.toString() +
                "        </center>\n" +
                "    </body>\n" +
                "</html>";

        response.setContentType("text/html; Charset=utf8");
        try(Writer writer = response.getWriter()) {
            writer.write(page);
        }
    }

}

//登陆后台那里 改成了进入login，原本是进入login.html ，因为，首先进入login，如果有账号密码，那么直接登陆.
//否则就是没有输入账号密码，两种情况，要么没有，要么已经登陆：
// 在session里面看，如果session为空，没登陆过，去登录界面。不为空登陆过，直接到admin
