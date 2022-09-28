package study9_28;

public class Cat extends Mamal{
    public String GetType() {
        return "cat";
    }

    @Override
    public void scream() {
        System.out.println("MiaoMiao……");
    }
}
