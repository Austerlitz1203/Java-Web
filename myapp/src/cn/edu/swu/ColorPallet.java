package cn.edu.swu;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class ColorPallet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int total=Integer.valueOf(request.getParameter("total"));
        int step=Integer.valueOf(request.getParameter("step"));

        response.setContentType("text/html");
        try(Writer writer=response.getWriter()){
            writer.write("<center><h1>This message comes from Servlet</h1></center>");

            int red=266,green=230,blue=230;
            for(int i=0;i<total;i++)
            {
                green-=step*i;
                blue-=step*i;
                writer.write("<div width='200px' height='20px'></div>");
            }
        }
    }
}
