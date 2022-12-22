
package database;


import java.sql.*;
public class ConnectionProvider
{
   public static Connection con=null;
    public Connection getConnection()
    {
       
        if(con==null)
        {
            System.out.println("Create new connection");
            try{
                
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","111111");
            
            }catch(Exception e)
            {
                System.out.println("@@@@ Connection provider Generate error :  " );
                e.printStackTrace();
            }
        }
        //7vu2uth//4mytivl
       
        return con;
    }
}
