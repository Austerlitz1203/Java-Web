package Exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class example {
//    public static void main(String[] args) {
//        FileReader reader=null;
//        try {
//            new FileReader("c:\\text.txt");
//        }catch(FileNotFoundException ex){
//            ex.printStackTrace();
//            throw new IOException("文件读取错误！");
//        }finally{
//            if(reader != null){
//                    reader.close();
//            }
//        }
//    }

    public static void main(String[] args) {
        int data[]={10,20,30,40,255};
        FileOutputStream outputStream=null;
        try{
            outputStream=new FileOutputStream("c:\\my.data");
            for (int i=0;i<data.length;i++){
                outputStream.write(data[i]);
            }
        }catch(FileNotFoundException ex){
            System.out.println("文件目录不存在");
        }catch(IOException ex){
            System.out.println("数据输出错误："+ex.getMessage());
        }finally{
            if(outputStream!=null){
                outputStream.close();
            }
        }
    }

}
