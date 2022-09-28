package study9_28;

public class Dog extends Mamal implements Magicfire,MagicWater{
    @Override
    public String GetType() {
        return "Dog";
    }

    @Override
    public void scream() {
        System.out.println("wangwang……");
    }

    @Override
    public void freeze() {
        System.out.println("freezeing");
    }

    @Override
    public void fire() {
        System.out.println("fire");
    }
}
