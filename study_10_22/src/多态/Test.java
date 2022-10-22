package 多态;

public class Test {
    //什么是多态：
    //多态两个条件：父类引用，引用子类对象（向上转型
    //父类和子类有同名的覆盖方法
    //通过父类引用，调用这个重写的方法（运行时绑定）


    public static void drawMap(Shape shape){
        shape.draw();  //就这一行代码，可以展现不同的形态，这就叫多态
    }

    public static void main(String[] args) {

        Shape shape1=new React();
        Shape shape2=new Circle();
        drawMap(shape1);
        drawMap(shape2);
    }
}
