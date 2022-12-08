package cn.edu.swu.hosuse;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;


/*
{
    "books": [
        {"id": 1, "name": "c program", "author":"tom", "price": 33, "describe": "good book", "picture": "./upload/1111.jpg"},
        {"id": 2, "name": "R program", "author":"jerry", "price": 33, "describe": "good book", "picture": "./upload/22222.jpg"}
    ]
}
 */

@WebServlet("/api/houses")
public class ListHouseApi extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<House> houses = HouseRepo.getInstance().getAll();
            response.setContentType("application/json; charset=UTF-8");
            try (Writer writer = response.getWriter()) {
                this.writeJsonByJackson(response.getWriter(), houses);
            }
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }

    private void writeJsonByJackson(Writer writer, List<House> houses)  throws IOException  {
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(houses);
        writer.write(json);
    }

    private void writeJson(Writer writer, List<House> houses) throws IOException {
        writer.write("{");
        writer.write("\"houses\":[");
        for (int i=0; i<houses.size(); i++) {
            if (i > 0) writer.write(",");
            House house = houses.get(i);
            writer.write(String.format(
                    "{\"id\":%s, \"name\":\"%s\", \"owner\":\"%s\", \"ownerPhone\":%s, \"price\":%s,\"describe\":\"%s\", \"picture\":\"%s\"}",
                    house.getId(), house.getName(),house.getOwner(), house.getOwnerPhone(), house.getPrice(),house.getDescribe(), house.getPicture()
            ));
        }
        writer.write("]");
        writer.write("}");
    }

}