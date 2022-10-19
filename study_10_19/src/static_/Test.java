package static_;

public class Test {
    public static void main(String[] args) {
      Person person1=new Person();
      Person person2=new Person();//new一个person，在堆里面就会产生一个对象，对象依然包含实例成员变量，但是静态成员变量有且仅有一份
      //实例成员变量
      person1.age();
      person1.name();

      //静态成员变量
      Person.height();

      //从这里可以看出，height有且仅有一份
      person1.age++;
      Person.height++;
      System.out.println(person1.age);
      System.out.println(Person.height);

      person2.age++;
      Person.height++;
      System.out.println(person2.age);
      System.out.println(Person.height);
    }
}
