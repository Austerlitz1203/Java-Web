package cn.edu.swu.user;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
//这里是所有网页都生效
public class AuthFilter extends HttpFilter {

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        System.out.println("auth filter");

        String uri = request.getRequestURI();
        System.out.println(uri);
        if ( uri.endsWith("login.html") || uri.endsWith("index.html") || uri.endsWith("verifyCode") ||
                uri.endsWith("png") || uri.endsWith("jpg") || uri.endsWith("css") || uri.endsWith("login")) {
            chain.doFilter(request, response);
            return;
        }

        if (session == null) {
            System.out.println("auth failed");
            response.sendRedirect("./login.html");
        } else {
            Boolean toke = (Boolean) session.getAttribute(LoginServlet.LOGIN_TOKEN);
            if (toke == Boolean.TRUE) {
                //这里还要判断的原因是，有的网站，即使不登陆也要验证session，所以这里验证一下session里的LOGIN_TOKEN
                //是否为true，为true则是登陆过，否则未登陆过。因为只有之前登陆正确才会设置它
                System.out.println("登录验证成功");
                chain.doFilter(request, response);
            } else {
                System.out.println("auth failed");
                response.sendRedirect("./login.html");
            }
        }
    }

}
