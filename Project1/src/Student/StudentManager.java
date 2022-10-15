package Student;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    public static void main(String[] args) throws IOException{
        List<Student> studentList=getStudent();

        StudentManager.printAll(studentList);

    }

    //读取信息，本地和网络的
    public static List<Student> getStudent() throws IOException{
        List<Student> studentList=StudentManager.getStudents1("C:\\Users\\Austerlitz\\Desktop\\students.txt");
        getStudents2(studentList);

        return studentList;
    }

    //读取本地信息
    public static List<Student> getStudents1(String path) throws IOException {
        List<Student> students=new ArrayList<Student>();
        FileInputStream in=new FileInputStream(path);
        InputStreamReader inr=new InputStreamReader(in);
        BufferedReader buf=new BufferedReader(inr);
        String s;
        while((s=buf.readLine())!=null){
            Student student=new Student();
            int index=s.indexOf("\t");
            student.getNum(s.substring(0,index));
            student.getName(s.substring(index+1));
            students.add(student);
        }
        in.close();
        buf.close();
        inr.close();
        return students;
    }

    //网页读取信息,传的是对象，会改变实参内容
    public static void getStudents2(List<Student> studentList){
            //下载文件的URL
            String fileUrl = "http://139.186.26.196/javaweb/data/math.txt";
            //通过下载文件的URL获取文件内容
            BufferedReader bf = null;
            String line;//文件每行内容
            try {
                URL url  = new URL(fileUrl);
                //建立URL链接
                URLConnection conn = url.openConnection();
                //设置模拟请求头
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                //开始链接
                conn.connect();
                //因为要用到URLConnection子类的方法，所以强转成子类
                HttpURLConnection urlConn = (HttpURLConnection) conn;
                //响应200
                if(urlConn.getResponseCode()==HttpURLConnection.HTTP_OK)
                {
                    //字节或字符读取的方式太慢了，用BufferedReader封装按行读取
                    bf =new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

                    while((line=bf.readLine())!=null)
                    {
                        String[] temp=line.split("\t");
                        //学好对应了则把成绩记录
                        for (Student stu:studentList){
                            if (temp[0].compareTo(stu.num) == 0){
                                stu.MatScore=Integer.valueOf(temp[1]);
                            }
                        }
                    }
                    //通过已获取的文件内容   FTP上传至服务器新建文件中
                }else{
                    System.out.println("无法链接到URL!");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } finally{
                try
                {
                    if(bf!=null){
                        bf.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
    }



    //网页读取信息,传的是对象，会改变实参内容
    public static void getStudents3(List<Student> studentList){
        //下载文件的URL
        String fileUrl = "http://139.186.26.196/javaweb/data/chinese.txt";
        //通过下载文件的URL获取文件内容
        BufferedReader bf = null;
        String line;//文件每行内容
        try {
            URL url  = new URL(fileUrl);
            //建立URL链接
            URLConnection conn = url.openConnection();
            //设置模拟请求头
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //开始链接
            conn.connect();
            //因为要用到URLConnection子类的方法，所以强转成子类
            HttpURLConnection urlConn = (HttpURLConnection) conn;
            //响应200
            if(urlConn.getResponseCode()==HttpURLConnection.HTTP_OK)
            {
                //字节或字符读取的方式太慢了，用BufferedReader封装按行读取
                bf =new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

                while((line=bf.readLine())!=null)
                {
                    String[] temp=line.split("\t");
                    //学好对应了则把成绩记录
                    for (Student stu:studentList){
                        if (temp[0].compareTo(stu.num) == 0){
                            stu.ChiScore=Integer.valueOf(temp[1]);
                        }
                    }
                }
                //通过已获取的文件内容   FTP上传至服务器新建文件中
            }else{
                System.out.println("无法链接到URL!");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            try
            {
                if(bf!=null){
                    bf.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }





    //打印所有信息
    public static void printAll(List<Student> studentList){
        for (Student stu: studentList){
            System.out.println(stu.num  +  "\t" +stu.name + "\t" +stu.MatScore);
        }
    }

}
