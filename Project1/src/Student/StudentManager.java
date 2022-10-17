package Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {

    static List<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args) throws IOException {
        studentList = GetStudent.getStudent();

        //测试打印全部信息
        printAll(studentList);

        //测试根据某一科分数区间找信息
        //findByScore("Math",80,90);

        //测试根据平均分分数区间找信息
        //findByScore(85,90);

        //测试根据ID找信息
        //getStudentById("222021321072008");

        //测试总分排序
        //List<Student> studentList2=sortByTotal();
        //printAll(studentList2);

        //测试写入本地文件
        saveAs();
    }

    //打印所有信息
    public static void printAll(List<Student> studentList) {
        for (Student stu : studentList) {
            String s = String.format("平均成绩：%.2f", stu.putAve());
            System.out.println("学号："+stu.putNum() + "," + "姓名："+stu.putName() + "," +"语文成绩："+ stu.putChi() + "," + "数学成绩："+stu.putMat() + ", " + "英语成绩："+stu.putEng() + "," + "平均分"+stu.putSum() + "," + s);

        }
    }

    public static void getStudentById(String id) {
        for (Student stu : studentList) {
            if (id.compareTo(stu.putNum()) == 0) {
                String s = String.format("%.2f", stu.putAve());
                System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);
            }
        }
    }

    public static void findByScore(String classType, int min, int max) {
        for (Student stu : studentList) {
            if (classType.compareTo("Math") == 0) {
                if (stu.putMat() >= min && stu.putMat() <= max) {
                    String s = String.format("%.2f", stu.putAve());
                    System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);
                }
            } else if (classType.compareTo("Chinese") == 0) {
                if (stu.putChi() >= min && stu.putChi() <= max) {
                    String s = String.format("%.2f", stu.putAve());
                    System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);
                }
            } else {
                if (stu.putEng() >= min && stu.putEng() <= max) {
                    String s = String.format("%.2f", stu.putAve());
                    System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);
                }
            }
        }
    }

    public static void findByScore(int min, int max) {
        for (Student stu : studentList) {
            if (stu.putAve() >= min && stu.putAve() <= max) {
                String s = String.format("%.2f", stu.putAve());
                System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);
            }
        }
    }

    public static List<Student> sortByTotal() {
        List<Student> temp = studentList;
        temp = temp.stream().sorted(Comparator.comparing(Student::putSum).reversed())
                .collect(Collectors.toList());
        //printAll(temp);
        return temp;
    }


    public static void saveAs() {
        String file="C:\\Users\\Austerlitz\\Desktop\\studentsCopy.txt";
        BufferedWriter out = null;
        for (Student stu:studentList)
        {
            try {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true)));
                out.write(stu.putNum()+",");
                out.write(stu.putName()+",");
                out.write(stu.putChi()+",");
                out.write(stu.putMat()+",");
                out.write(stu.putEng()+",");
                out.write(stu.putSum()+",");
                String s = String.format("%.2f", stu.putAve());
                out.write(s+"\r\n");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static ArrayList<Student> studentArrayList() {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("C:\\Users\\Austerlitz\\Desktop\\students.txt"), "utf8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(isr);
        ArrayList<Student> ar = new ArrayList<Student>();
        String line;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] strArray1 = line.split("\t", 2);
            int index = line.indexOf("\t");
            Student s = new Student();
            s.getNum(line.substring(0, index + 1));
            s.getName(line.substring(index + 1));
            ar.add(s);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        //for (Student s : ar) {
        // System.out.println(String.format("姓名:%s学号:%s", s.getId(), s.getName()));
        //}
        return ar;
    }

}
