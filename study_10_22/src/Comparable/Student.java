package Comparable;

public class Student implements Comparable<Student>{  //自定义类型排序，必须要implements Comparabel<自定义类型>
    String name;
    int age;
    int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {   //  还要重写comparaeTo方法
        if (this.age > o.age){  // >0从小到大排序   <0从大到小排序
            return 1;
        } else if (this.age == o.age) {
            return 0;
        }else{
            return -1;
        }
    }
}
