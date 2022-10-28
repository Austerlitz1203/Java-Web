package clone;

public class Person implements Cloneable{
    int age;

    Money m=new Money();

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Person p=(Person) super.clone();
            p.m=(Money) this.m.clone();
        return p;
    }
}
