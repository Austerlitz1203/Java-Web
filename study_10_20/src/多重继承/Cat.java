package 多重继承;


public class Cat extends Animal { //父类有 含有参数的 构造方法，而子类不构造父类，会报错
    public Cat(String name){//写了这句之后，这里报错，上面一行不报错

        //super.name=“hahha”;  这样子不可以，
        //构造一个对象，只能调用构造方法，super.name只是把父类的name初始化，并没有调用构造方法

        super(name);//显式调用，不是继承，无法继承父类的构造方法，且必须放在第一行
        System.out.println("姓名是："+this.name);
    }


}
