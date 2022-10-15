package Student;

public class Student {
    String num;
    String name;
    int MatScore;
    int ChiScore;
    int EngScore;
    int SumScore;
    int AveScore;

    //构造函数


    public void getNum(String num){
        this.num=num;
    }

    public void getName(String name){
        this.name=name;
    }
    public void getMath(int Math){
        this.MatScore=Math;
    }
    public void getChi(int Chi){
        this.ChiScore=Chi;
    }
    public void getEng(int Eng){
        this.EngScore=Eng;
    }
    public void getSum(int Sum){
        this.SumScore=Sum;
    }
    public Void getAve(int Ave){
        this .AveScore=Ave;
    }

}
