package Comparable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student student1=new Student("zhangsan",19,89);
        Student student2=new Student("lisi",11,99);
        Student student3=new Student("wangwu",6,88);

        Student[] students=new Student[3];
        students[0]=student1;
        students[1]=student2;
        students[2]=student3;

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
