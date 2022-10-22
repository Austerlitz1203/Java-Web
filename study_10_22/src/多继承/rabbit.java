package 多继承;

public class rabbit extends Animal implements IRunning{

    public rabbit(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"正在一蹦一跳地跑");
    }
}
