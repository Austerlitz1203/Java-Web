package people;

public class people {
        private int age;
        protected String name;//"test"类的属性,改成protected,子类才可以访问父类的属性
        private boolean gender;
        public people(String name,int age,boolean gender)
        {
            this.name=name;
            this.age=age;
            this.gender=gender;
        }

        public void introducemyself()//"test"类的方法
        {
            System.out.println("My name is "+this.name+",I am "+this.age+" years old");
        }
}

