package 多继承;

public class Robot implements IRunning{
    @Override
    public void run() {
        System.out.println("我是机器人，我在用机械腿跑！");
    }
}
