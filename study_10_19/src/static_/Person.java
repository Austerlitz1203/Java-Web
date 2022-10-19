package static_;

public class Person {

    //字段、属性、成员变量，三者都是一个东西，都是类里面，方法之外定义的
    //对于一个对象的字段，如果没有设置初值，会有一个默认的初始值：
    //对于各种数字类型，默认初始值为0
    //对于boolean类型，默认初始值为false
    //对于引用类型（String、Array、以及自定制类）默认值为null，注意这里和C语言不一样，这里的null是“空引用”的意思，表示不引用任何对象

    //实例成员变量    访问：对象名.成员变量名
    String name;
    int age;

    //静态成员变量    访问：类名.静态成员变量名    这个变量是在方法区，是属于类的，不是属于成员的
    static int height;

    //方法
    //实例方法
    public void name(){
        int a=10;//这个是局部变量
        System.out.println("name()");
    }

    public void age(){
        System.out.println("age()");
        height();//但是，非静态方法没有限制，可以调用静态方法。
        height=100;//也可以访问静态成员
    }


    //静态方法
    public static void height(){
        //age=99;//静态方法内部不可以访问非静态成员
        height=100;//可以访问静态成员
        //age();//也不可以调用非静态方法，只可以调用静态方法
        System.out.println("height()");
    }
}
