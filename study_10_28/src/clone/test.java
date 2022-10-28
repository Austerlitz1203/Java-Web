package clone;

import java.util.Arrays;

public class test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1=new Person();
        person1.age=10;
        Person person2=(Person) person1.clone();
        person2.age=90;
        person2.m.money=100;
        //同样的，要对Money这个类implements Clone并重新给clone方法才可以，而且还要在Person里面的clone方法写上clone Money
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);//现在不一样了，是深拷贝
    }

    public static void main3(String[] args) throws CloneNotSupportedException {
        Person person1=new Person();
        person1.age=10;
        Person person2=(Person) person1.clone();
        person2.age=90;
        person2.m.money=100;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        //在这里，发现两个money都是一样的，因为在Person里面new的m是一个引用，指向堆区的一块内存，里面装的是money，clone
        //person1的时候，也clone了这个引用，但是没有clone一个新的内存存放新的money

    }

    public static void main2(String[] args) throws CloneNotSupportedException {
        Person person1=new Person();
        person1.age=10;
        //Person person2=person1.//在这里，发现找不到person1.clone，因为没有在person1里面重写clone方法

        Person person2=(Person) person1.clone();
        //这样的话，在栈区拷贝的person2引用，会在堆区指向一个新的，和person1指向的一摸一样的内容
        person2.age=90;
        System.out.println(person1.age);
        System.out.println(person2.age);

    }


    public static void main1(String[] args) {
        int[] array1={1,2,3,4,5};
        int[] array2=array1.clone();
        array2[0]=99;
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        //这是深拷贝，拷贝的array2和array1是独立的，相当于C中的传值
    }
}
