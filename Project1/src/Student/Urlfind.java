package Student;

import java.net.URL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
public class Urlfind {

    public static String openFile(String filePath) throws IOException {
        int HttpResult; // 服务器返回的状态
        String ee = null;
        try
        {
            URL url =new URL(filePath); // 创建URL
            URLConnection urlconn = url.openConnection(); // 试图连接并取得返回状态码
            urlconn.connect();
            HttpURLConnection httpconn =(HttpURLConnection)urlconn;
            HttpResult = httpconn.getResponseCode();
            if(HttpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到");
            } else {
                int filesize = urlconn.getContentLength(); // 取数据长度
                InputStreamReader isReader = new InputStreamReader(urlconn.getInputStream(),"UTF-8");
                BufferedReader reader = new BufferedReader(isReader);
                StringBuffer buffer = new StringBuffer();
                String line; // 用来保存每行读取的内容
                line = reader.readLine(); // 读取第一行
                while (line != null) { // 如果 line 为空说明读完了
                    buffer.append(line); // 将读到的内容添加到 buffer 中
                    buffer.append("\n"); // 添加换行符
                    line = reader.readLine(); // 读取下一行
                }
                //System.out.print(buffer.toString());
                ee = buffer.toString();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  ee;
    }
}
