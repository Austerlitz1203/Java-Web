package 抽象类;

//抽象类：
//1、抽象方法，一个方法如果被abstract修饰，那么这个方法就是抽象方法。抽象方法可以没有具体的实现。
//2、包含抽象方法的类叫做抽象类。
//注意：
//1、抽象类不可以被实例化，即抽象类不可以new一个对象
//2、类内的数据成员，和普通类没有区别
//3、抽象类主要就是用来被继承的
//4、如果一个类继承了抽象类，那么必须重写里面的抽象方法
//5、如果A继承B抽象类，当A是抽象类的情况下，A可以不重写B中的抽象方法，但是如果又有C类继承了A，而C不是抽象类，那么C要重写这个抽象方法

public class Test {

    public static void drawShape(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {

        //除了上述区别，其他和正常类别无二致
        Shape shape1=new Circle();
        Shape shape2=new React();
        drawShape(shape1);
        drawShape(shape2);
    }



}
