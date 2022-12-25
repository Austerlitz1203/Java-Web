package cn.edu.swu.hosuse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteHouse")
public class DeleteHouseServlet extends HttpServlet  {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try {
            HouseRepo.getInstance().deleteHouse(Long.valueOf(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./listHouse");
    }
}