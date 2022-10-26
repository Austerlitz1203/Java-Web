
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        //第一步，获得链接
        String jdbcUrl="";
        String username="root";
        String password="123456";
        String sql="select ud ,title,price from book";

        Connection connection= DriverManager.getConnection(jdbcUrl,username,password);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);

        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String title=resultSet.getString("title");
            float price =resultSet.getFloat("price");

            System.out.println(id+"  "+ title+"  "+price);
        }

    }
}
