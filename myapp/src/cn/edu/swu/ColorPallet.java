package cn.edu.swu;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
@WebServlet("/color")
public class ColorPallet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        int red=Integer.valueOf(request.getParameter("red"));
//        int green = Integer.valueOf(request.getParameter("green"));
//        int blue = Integer.valueOf(request.getParameter("blue"));
        int total=Integer.valueOf(request.getParameter("total"));
        int step=Integer.valueOf(request.getParameter("step"));
        String describe = request.getParameter("describe");

        response.setContentType("text/html");
        try(Writer writer=response.getWriter()){
            writer.write("<center><h1>This message comes from Servlet</h1></center>");
            int red=255,green=230,blue=230;
            for(int i=0;i<total;i++)
            {
                green-=step*i;
                blue-=step*i;
                writer.write(
                   String.format("<div width='200px' height='20px' style='background-color:rgb(%s %s %s)' >&nbsp;</div><br>"
                         ,red,green,blue)
                );

            }
        }
    }
}
