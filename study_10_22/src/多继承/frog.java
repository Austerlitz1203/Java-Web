package 多继承;

public class frog extends Animal implements IRunning,ISwimming{

    public frog(String name) {
        super(name);
    }

    @Override
    public void run() {  //重写的时候默认是public，而且也必须是public，因为父类就是默认public，子类要大于等于父类。不写就是默认default，包访问，小于
        System.out.println(this.name+"正在跑步");
    }

    @Override
    public void swim() {
        System.out.println(this.name+"正在游泳");
    }
}
