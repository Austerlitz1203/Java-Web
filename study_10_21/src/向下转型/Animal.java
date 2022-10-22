package 向下转型;

public class Animal {
    String name;
    public Animal(String name){
        this.name=name;
    }

    public void eat(){
        System.out.println(this.name+"  Animal::eat()");
    }
}
