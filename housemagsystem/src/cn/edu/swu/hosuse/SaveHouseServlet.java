package cn.edu.swu.hosuse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/saveHouse")
public class SaveHouseServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String price = request.getParameter("price");
        String ownerPhone=request.getParameter("ownerPhone");
        String describe = request.getParameter("describe");

        House house = new House();
        house.setName(name);
        house.setOwner(owner);
        house.setPrice(Float.valueOf(price));
        house.setOwnerPhone(ownerPhone);
        house.setDescribe(describe);
        System.out.println(String.format("%s, %s, %s,%s, %s", name, owner, ownerPhone,price, describe));

        String message = null;
        try {
            HouseRepo.getInstance().saveHouse(house);
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
