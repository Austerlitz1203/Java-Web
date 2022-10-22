package 多继承;

//比如飞、跑步、游泳、如果设计成animal里面的抽象方法，那么每一个继承Animal的都要实现这三个方法，但是不是每一个动物都同时会飞、跑步、游泳
//如果写成不同的类，可是java只能继承一个普通类/抽象类，所以有了接口
//可以不用在意是什么类
public class Test {

    public static void run(IRunning iRunning){
        iRunning.run();
    }


    public static void main(String[] args) {
        IRunning iRunning1=new frog("wawa");//可以不用在乎到底是什么类，肯定是实现了IRunning这个接口的，可以跑
        IRunning iRunning2=new Robot();//向上转型
        run(iRunning1);
        run(iRunning2);//多态
    }


}
