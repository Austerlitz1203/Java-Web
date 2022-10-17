package Student;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class GetStudent {
    public static List<Student> getStudent() throws IOException {
        //读取姓名学号
        List<Student> studentList=getStudents1("C:\\Users\\Austerlitz\\Desktop\\students.txt");

        studentList=studentGrades();
        average((studentList));
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
            student.getNum(s.substring(0,index+1));
            student.getName(s.substring(index+1));
            students.add(student);
        }
        in.close();
        buf.close();
        inr.close();
        return students;
    }
    public static void average(List<Student> students){
        for(Student stu:students)
        {
            stu.getAve(stu.putEng()/3.0+stu.putMat()/3.0+stu.putChi()/3.0);
        }
    }

    public static ArrayList<Student> studentGrades() throws IOException {
        String studentMath = Urlfind.openFile("http://139.186.26.196/javaweb/data/math.txt");
        String studentChinese = Urlfind.openFile("http://139.186.26.196/javaweb/data/english.txt");
        String studentEnglish = Urlfind.openFile("http://139.186.26.196/javaweb/data/english.txt");
        ArrayList<Student> students = StudentManager.studentArrayList();
        ArrayList<Student> studentsMain1 = new ArrayList<>();
        ArrayList<Student> studentsMain2 = new ArrayList<>();
        ArrayList<Student> studentsMainFinnal = new ArrayList<>();
        ArrayList<Student> studentsMathGrades = new ArrayList<>();
        ArrayList<Student> studentsChineseGrades = new ArrayList<>();
        ArrayList<Student> studentsEnglishGrades = new ArrayList<>();
        String[] stuM = studentMath.split("\n");
        String[] stuC = studentChinese.split("\n");
        String[] stuE = studentEnglish.split("\n");
        for (String s : stuM) {
            int index = s.indexOf("\t");
            Student stu = new Student();
            stu.getNum(s.substring(0, index + 1));
            stu.getMath(Integer.valueOf(s.substring(index + 1)));
            studentsMathGrades.add(stu);
        }
        for (Student temp1 : students) {
            for (Student temp2 : studentsMathGrades) {
                if (temp2.putNum().equals(temp1.putNum())) {
                    temp1.getMath(temp2.putMat());
                    studentsMain1.add(temp1);
                }
            }
        }
        // -------------
        for (String s : stuC) {
            int index = s.indexOf("\t");
            Student stu = new Student();
            stu.getNum(s.substring(0, index + 1));
            stu.getChi(Integer.valueOf(s.substring(index + 1)));
            studentsChineseGrades.add(stu);
        }
        for (Student temp1 : studentsMain1) {
            for (Student temp2 : studentsChineseGrades) {
                if (temp2.putNum().equals(temp1.putNum())) {
                    temp1.getChi(temp2.putChi());
                    studentsMain2.add(temp1);
                }
            }
        }
        //--------------
        for (String s : stuE) {
            int index = s.indexOf("\t");
            Student stu = new Student();
            stu.getNum(s.substring(0, index + 1));
            stu.getEng(Integer.valueOf(s.substring(index + 1)));
            studentsEnglishGrades.add(stu);
        }
        for (Student temp1 : studentsMain2) {
            for (Student temp2 : studentsEnglishGrades) {
                if (temp2.putNum().equals(temp1.putNum())) {
                    temp1.getEng(temp2.putEng());
                    Integer avager = Avager(temp1);
                    temp1.getSum(avager * 3);
                    studentsMainFinnal.add(temp1);
                }
            }
        }
        //--------------
        return studentsMainFinnal;

    }


    public static Integer Avager(Student s) {
        return (Integer.valueOf(s.putChi()) + Integer.valueOf(s.putMat()) + Integer.valueOf(s.putEng())) / 3;
    }


}
