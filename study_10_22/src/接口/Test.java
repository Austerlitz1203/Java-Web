package 接口;

public class Test {
    public static void drawShape(Shape shape){
        shape.draw();
    }


    public static void main(String[] args) {
        Shape shape1=new Circle();
        Shape shape2=new React();
        drawShape(shape1);
        drawShape(shape2);
    }
}
