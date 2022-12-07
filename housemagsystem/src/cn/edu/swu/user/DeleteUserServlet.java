package cn.edu.swu.user;

import cn.edu.swu.hosuse.HouseRepo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet  {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try {
            UserRepo.getInstance().deleteUser(Long.valueOf(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("./listUser");
    }
}