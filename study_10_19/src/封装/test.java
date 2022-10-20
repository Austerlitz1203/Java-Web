package 封装;

public class test {

    public static void main(String[] args) {
        //Student student=new Student();//有构造方法之后，并不会提供默认构造方法


        //Student student1=new Student("zhangsan",10);
        //Student student2=new Student();//有构造方法之后，并不会提供默认构造方法


        //一个对象的产生分为两步：1、为对象分配内存  2、调用合适的构造方法
        //this代表当前对象的引用，而不是代表对象
        //如果this代表对象，那么在构造函数里面，还没构造完就使用了this，矛盾，所以错的
        //一定要习惯使用this

        //this();调用自己的构造方法  注意：只能在构造函数里面写，并且只能调用一次,因为其只能写在第一行
        //this.data  调用当前对象的属性
        //this.func()  调用给当前对象的方法
        Student student=new Student();
        System.out.println(student);//可以看出，无参数的构造方法里面的this(); 调用了有两个参数的构造方法
    }



//    public static void main(String[] args) {
//        Student student=new Student();
//        //student.getName();
//        //System.out.println(student);//直接打印对象就可以，和toString联系起来，如果不重写toString，那么对象里存的是地址，直接打印出地址
//    }

}
