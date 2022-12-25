package cn.edu.swu.inout;

import cn.edu.swu.user.User;
import cn.edu.swu.user.UserRepo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            //为什么要有这个判断，因为点了登陆之后，他是跳到login的，即这个loginservlet，所以要在这里有
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

    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");

        String code = request.getParameter("code");

        String verifyCode = (String) request.getSession(true).getAttribute(ValidateCodeServlet.LOGIN_VERIFY_CODE);
        if (code == null || !code.equalsIgnoreCase(verifyCode)) {
            System.out.println("验证码错误");
            response.sendRedirect("./login.html");
            return;
        }

        try {
            User user = UserRepo.getInstance().auth(userName, password);
            if (user != null) {
                HttpSession session=request.getSession();
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
