package 继承;

public class Test {

    public static void main(String[] args) {
        Dog dog=new Dog();
        System.out.println(dog.test);//同一个包里面不同类可以访问
    }

    public static void main4(String[] args) {//default
        Package1 package1=new Package1();//同一个包里面的类可以访问

    }

    public static void main3(String[] args) {
        Bird bird=new Bird("kiki");
        bird.age=10;//把age设乘private，那么除了Animal类，其他类无法访问，但是如果设置成protected，那么子类可以访问
                    //protected  同一包里面的所有类可以访问,不同包里面的子类也可以
    }


    //this和super的区别
    //this是当前对象的引用，不是创建一个对象（两个条件）
    //1、this();调用当前类 别的构造函数
    //2、this.data; 调用当前类的成员变量
    //3、this.func(); 调用当前类的函数
    //super 对父类对象的引用
    //1、super(); 调用父类的构造方法    注意一定要写在第一行
    //2、super.data(); 调用父类的属性
    //3、super.func(); 调用父类的方法

    public static void main2(String[] args) {
        Cat cat=new Cat("mimi");
    }


    public static void main1(String[] args) {
        //Cat cat=new Cat();//因为父类并没有定义构造方法，所以调用默认构造方法，无参数，直接调用，我们看不到这个过程
                          //但是如果父类定义了构造方法，子类没有先构造父类，就会出错
        //cat.name="mimi";
        //cat.eat();
        //cat.sleep();//sleep改成私有了，这里报错，不是不能被继承，而是不能在外部访问，只能够在Animal类内部访问，和private
                    //成员变量类似，实际上是被继承了的
        //子类继承了除构造方法以外的所有
    }
}
