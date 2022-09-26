package study9_26;

public class test {
    public static void main(String[] args) {
        Book a=new Book("santi","liucixing",1000,"12876237");
        Book b=new Book("santi","liucixing",1000,"12876237");
        a.getowner("using");
        a.putowner();
        b.putowner();

        boolean jud=a.Equal(b);
        if (jud){
            System.out.println("Books are the same!");
        }
        else {
            System.out.println("Books are different!");
        }
        Complex a1=new Complex(1,2);
        Complex a2=new Complex(3,4);
        Complex a3=a1.Add(a2);
        System.out.println("a1 + a2 = " + a3.getReal() +" "+a3.getIma());

        ScientificBook c=new ScientificBook("dwa","dwadd",45,"2318742","dsadsa");
        System.out.println(a instanceof ScientificBook);//instanceof是指a变量是不是后面的new出来的
        System.out.println(c.getClass());//getclass得到类名
    }
}
