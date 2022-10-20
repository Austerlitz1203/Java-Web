import 继承.Dog;

public class TestDemo1  extends Dog {
    //测试protected

    public void test2(){
        Dog dog=new Dog();
        //System.out.println(dog.test);//依然错误的
        System.out.println(super.test);//这里正确了，这是因为，super是依赖父类的对象的，而static不依赖对象
    }


    public static void test1(){
        Dog dog=new Dog();
        //System.out.println(dog.test);//依然错误的
        //System.out.println(super.test);//这里还是错误
    }


//    public static void main(String[] args) {
//        Dog dog=new Dog();
//        System.out.println(dog.test);  //这样子是错误的
//        System.out.println(super.test);  //可以用super，但是不能在这里
//    }

}
