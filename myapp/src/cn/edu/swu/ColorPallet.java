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
        this.doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int red=Integer.valueOf(request.getParameter("red"));
        int green = Integer.valueOf(request.getParameter("green"));
        int blue = Integer.valueOf(request.getParameter("blue"));
        int total=Integer.valueOf(request.getParameter("total"));
        int step=Integer.valueOf(request.getParameter("step"));
        String describe = request.getParameter("describe");

        response.setContentType("text/html");
        try(Writer writer=response.getWriter()){
            writer.write("<center>"+describe+"</h1></center>");
            for(int i=0;i<total;i++)
            {
                green-=step*i;
                blue-=step*i;
                writer.write(
                        String.format("<center><div style='width:200px;height:20px;background-color:rgb(%s %s %s)' ></div><center>"
                                ,red,green,blue)
                );

            }
        }
    }



}
