package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws  IOException{
        Main main=new Main();
        String filePath="C:\\Users\\Austerlitz\\Desktop\\data\\students.txt";
        main.readStudentFromFile(filePath);

    }

    public void readStudentFromFile(String filePath) throws IOException{
        FileInputStream fileInputStream=new FileInputStream(filePath);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader   reader=new BufferedReader(inputStreamReader);

        String line=null;
        while((line= reader.readLine())!=null){
            if (line.trim().isEmpty())  continue;//空行的判断，是空行则什么都不做
            Student student=this.createStudent(line);
            System.out.println(student.toString());  // Alt+Enter
        }

        fileInputStream.close();
    }

    private Student createStudent(String line){
        String[] vals=line.split("\t");
        Student student=new Student();
        student.setID(vals[0]);
        student.setName(vals[1]);
        return student;
    }


}
