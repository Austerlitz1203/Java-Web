package 向上转型;

public class Animal {
    String name;
    public Animal(String name){
        this.name=name;
        eat();
    }

    public void eat(){
        System.out.println(this.name+"  Animal::eat()");
    }
}
