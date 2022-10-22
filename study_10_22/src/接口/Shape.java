package 接口;

//接口：
//1、接口中的方法，都是抽象方法
//2、其实可以有实现的方法，用deafault修饰，在JDK1.8之后才有的，但是一般不用
//3、接口中定义的成员变量，默认是常量
//4、接口中成员变量默认是： public static final   成员方法是：public abstract
//5、接口不可以被实例化
//6、接口和类之间的关系：implements
//7、接口是为了解决java中单继承的关系，可以实现多个接口
//8、只要这个类实现了该接口，就可以实现向上转型、多态等等


interface Shape {

    public static final int a=10;//这样是可以的，接口中定义的变量成员，默认是常量，常量一般默认static final修饰
    int b=6;//这里也是默认省略
    //public int a;//错的

    void draw(); //在这里尽量把public abstract省略，因为是默认的
}
