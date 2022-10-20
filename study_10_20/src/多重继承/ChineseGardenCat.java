package 多重继承;

final class ChineseGardenCat extends Cat{

    //一般情况下，继承不要超过三四层左右

    public ChineseGardenCat(String name){
        super(name); // 只需要构造父类的构造方法，然后父类的父类自然会被构造
    }
}
