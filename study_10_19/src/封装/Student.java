package 封装;

public class Student {
    //限定只能在类里面访问private修饰的成员，一方面可以保护该成员变量，另一方面，如果这个类里面的成员变量名字改了
    //外面调用调用的时候，也要更改，那样就很麻烦，所以要用private修饰
    //如无特殊要求，所有属性要设置为private
    private String name;
    private int age;

    //构造方法
    //没有提供构造方法的时候，会自动提供一个不带参数的构造方法
    //有了构造方法，编译器就不会自动提供给构造方法
    //构造方法作用：实例化一个对象
    //构造方法不止一个，可以多个
    //ctr+alt+s里的construct就是自动生成构造方法

    public Student(){
        this("zhangsan",20);
        System.out.println("Hello");
    }
    public Student(String Name,int Age){
        this.name=Name;
        this.age=Age;
        System.out.println("world");
    }

    //已改快捷键，ctrl+alt+s自动生成
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //设置一个公开的接口可以访问private修饰的成员
    public String getName(){
        return name;
    }

    public void setName(String name){
        //name=name;根据局部变量优先的原则，两个变量名一样，那么优先表示局部变量，所以这里是自己给自己赋值，并没有赋值属性
        this.name=name;//this代表当前对象的引用
    }

    public void print(){
        System.out.println("我叫:"+this.name+"今年"+this.age+"岁。");
    }


    //private修饰方法也是类似，只能够在这个类中调用
    private void func1(){
        System.out.println("func1()");
    }

    //重新实现了Object的方法，object是所有类的父类
    //重写方法，也是ctrl+alt+s快捷键，选择toString自动生成，用于成员变量多的时候，这样子方便打印
    @Override//注解，表示这个放啊是重写的
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
