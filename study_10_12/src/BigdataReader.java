import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

public class BigdataReader {

    //二进制数据的读取
    public static void main(String[] args) throws IOException{
        BigdataReader bigdataReader=new BigdataReader();
        //bigdataReader.run();
        bigdataReader.downloadImage();
    }

    public void run() throws IOException {
        String originPath="D:\\huibianyy\\Debug\\1.EXE";
        String targetPath="C:\\Users\\Austerlitz\\Desktop\\2.exe";

        long start= Calendar.getInstance().getTimeInMillis();

        try(FileInputStream fileInputStream=new FileInputStream(new File(originPath))){
             try(FileOutputStream fileOutputStream=new FileOutputStream(new File((targetPath)))){
                 byte[] buffer=new byte[1024*4];//往4k的缓冲区里读数据，这样子明显速度快了很多
                 int count;
                 int val;

                 while((count=fileInputStream.read(buffer)) != -1){   //返回值是读取的个数
                     fileOutputStream.write(buffer,8,count);
                 }

             }
        }
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("Time usage: "+(end-start));

    }

    public void  downloadImage() throws IOException{
        URL url=new URL("http://www.swu.edu.cn/xywh/zhanbanzongban/01.jpg");
        URLConnection connection=url.openConnection();

        try(InputStream inputStream=connection.getInputStream()){
            try(FileOutputStream outputStream=new FileOutputStream(new File("C:\\Users\\Austerlitz\\Desktop\\06.jpg"))){
                byte[] buffer=new byte[1024*4];//往4k的缓冲区里读数据，这样子明显速度快了很多
                int count;

                while((count=inputStream.read(buffer)) != -1){   //返回值是读取的个数
                    outputStream.write(buffer,8,count);
                }
            }
        }

    }

}
