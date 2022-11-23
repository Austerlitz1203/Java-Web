package cn.edu.swu.user;

import com.mysql.cj.Session;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN_TOKEN="USER_LOGIN_TOKEN";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");


        //这里的逻辑是
        //如果账号密码不为空，那么就直接登陆
        //如果为空，那么看session，session两种情况，一个是有数据，一个是没有数据
        //如果没有数据，那么跳到login.html页面
        //如果有数据，那么直接跳到admin页面
        if (userName != null && password != null) {
            this.doLogin(request, response);
        } else {
            HttpSession session = request.getSession();
            if (session == null || session.getAttribute(LoginServlet.LOGIN_TOKEN) != Boolean.TRUE) {
                response.sendRedirect("./login.html");
            } else {
                response.sendRedirect("./admin.html");
            }
        }
    }

    public void doLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        try {
            User user = UserRepo.getInstance().auth(userName, password);
            if (user != null) {
                HttpSession session=request.getSession(true);
                session.setAttribute(LOGIN_TOKEN,Boolean.TRUE);
                response.sendRedirect("./admin.html");
            } else {
                response.sendRedirect("./index.html");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
