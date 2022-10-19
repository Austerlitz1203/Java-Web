package 封装;

public class test {

    public static void main(String[] args) {
        //Student student=new Student();//有构造方法之后，并不会提供默认构造方法


        Student student1=new Student("zhangsan",10);
        //Student student2=new Student();//有构造方法之后，并不会提供默认构造方法
    }

//    public static void main(String[] args) {
//        Student student=new Student();
//        //student.getName();
//        //System.out.println(student);//直接打印对象就可以，和toString联系起来，如果不重写toString，那么对象里存的是地址，直接打印出地址
//    }

}
