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
        //printAll(studentList);

        //测试根据某一科分数区间找信息
        //findByScore("Math",80,90);

        //测试根据平均分分数区间找信息
        //findByScore(85,90);

        //测试根据ID找信息
        //getStudentById("222021321072008");

        //测试总分排序
        //List<Student> studentList2=sortByTotal();
        //printAll(studentList2);

        saveAs();

    }

    //打印所有信息
    public static void printAll(List<Student> studentList) {
        System.out.println("学号\t\t\t\t姓名\t\t语文成绩，数学成绩，外语成绩，总分，平均分");
        for (Student stu : studentList) {
            String s = String.format("%.2f", stu.putAve());
            System.out.println(stu.putNum() + "," + stu.putName() + "," + stu.putChi() + "," + stu.putMat() + ", " + stu.putEng() + "," + stu.putSum() + "," + s);

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

        for (Student stu : studentList) {
            try {
                Student content=stu;
                File file = new File("C:\\Users\\Austerlitz\\Desktop\\studentsCopy.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(stu.putNum()+',');
                bw.write(stu.putName()+',');
                bw.write(stu.putChi()+',');
                //bw.write(stu.putEng()+',');
                //bw.write(stu.putSum()+',');
                bw.write("\r\n");
                //bw.write(stu.putAve());

                bw.close();
                System.out.println("finish");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
