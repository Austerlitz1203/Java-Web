package study9_28;

public abstract class Mamal extends animal {//这里如果没有实现父类GetType，则报错，或者把Mamal弄成抽象类

    public void run(){
        System.out.println("running");
    }
    public abstract void scream();//在这里规定了所有哺乳动物都可以叫，但是每个动物叫声不一样，所以规定为abstract，子类自己去实现
}
