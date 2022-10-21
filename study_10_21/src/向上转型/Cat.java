package 向上转型;

public class Cat extends Animal{

    public Cat(String name){
        super(name);

    }

    public void sleep(){

        System.out.println(this.name+"Cat::sleep()");
    }

    //重写
    public void eat(){
        System.out.println(this.name+"  Cat::eat()");
    }

}
