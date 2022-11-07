package cn.edu.swu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/second") // 这种方式不用配置servlet，是采用注释的方式。但是xml文件里面要改成false
public class SecondServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        try(Writer writer=response.getWriter()){
            writer.write("<center><h2>This message comes from Servlet<h2><center>");
        }
    }
}
