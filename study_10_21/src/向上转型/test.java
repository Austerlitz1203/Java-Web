package 向上转型;


public class test {

    //重写注意事项：
    // 1、要被重写的方法，不能被final修饰。
    //2、要被重写的方法，访问限定修饰符不能是private
    //3、子类的重写方法，子类的访问限定修饰符要>=父类的访问限定修饰符    private < default < protected < public

    //重写： 在子类中
//1、方法名一样
//2、参数一样
//3、返回只一样
//
//重载： 在同一个类中
//1、方法名相同
//2、参数不同
//3、返回值随意

    //运行时绑定：
    //父类引用，引用子类对象，同时，通过父类引用调用同名的覆盖方法，此时会发生运行时绑定

    //构造方法里面调用被重写的方法，也会发生动态绑定
    public static void main(String[] args) {
        Animal animal=new Cat("miaomiao");
        //animal.eat();//运行的时候，调用的是子类的方法，因为子类里面重写了eat方法，这个过程叫运行时绑定
    }





    public static Animal func1(){
        return new Cat("wwa");
    }

    public  static void func(Animal animal){
        animal.eat();
    }
    public static void main1(String[] args) {
        //发生向上转型的时机
        //1、直接赋值
        //2、传参
        //3、返回值

        Cat cat=new Cat("huahua");
        func(cat);

        Animal animal=new Cat("MImi");  //向上转型，把子类赋值给父类
        animal.eat();
        //animal.sleep();//error ，向上转型只能访问父类的，不能访问子类的属性和方法
    }


}
