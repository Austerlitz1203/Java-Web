package 向下转型;

public class test {
    public static void main(String[] args) {
        Animal animal=new Bird("kiko");

        //向下转型
        Bird bird=(Bird) animal;
        bird.fly();

        //不安全的向下转型
        //Cat cat=(Cat) animal; //目前不会报错，但是运行会报错

        //A instance of B    判断A是不是B的一个实例      一般用向下转型比较少
        if(animal instanceof Cat){
            Cat cat=(Cat) animal;
        }
        else {
            System.out.println("not");
        }


    }


}
