package 继承;

public class Animal {
    protected String name;
    public int age;

    public Animal(String name){
        this.name=name;
        System.out.println("父类构造方法！");
    }
    public void eat(){
        System.out.println(this.name+"Animal::eat()");
    }

    private void sleep(){
        System.out.println("Animal::sleep()");
    }


}
