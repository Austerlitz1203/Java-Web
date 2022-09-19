package people;

//子类，其父类是people
public class student extends people{
    private int num;
    private String major;
    //这个要有
    public student(String name, int age, boolean gender) {
        super(name, age, gender);
    }

    public student(String name, int age, boolean gender,String major) {
        super(name, age, gender);
        this.major=major;
    }
    public void introduceself()
    {
        System.out.println("My name is "+this.name+",I study "+this.major);
    }
}
