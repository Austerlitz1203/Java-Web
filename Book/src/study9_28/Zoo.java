package study9_28;

public class Zoo {
    //animal a=new animal();//不能new 一个animal，因为其是abstruct的，即抽象的
    public static void main(String[] args) {
        Cat a=new Cat();
        System.out.println(a.GetType());

        Mamal[] c=new Mamal[]{
                new Cat(),
                new Dog()
        };

        for(int i=0;i<c.length;i++)
        {
         Mamal  mamal=c[i];
            System.out.println(c[i].GetType());
            c[i].run();
            c[i].scream();
        }
        Dog d=new Dog();
        d.fire();

    }
}
