package Student;

public class Student {
    private String num;
    private String name;
    private int MatScore;
    private int ChiScore;
    private int EngScore;
    private int SumScore;
    private double AveScore;


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
        this.SumScore+=Sum;
    }
    public void getAve(double Ave){
        this .AveScore+=Ave;
    }

    public String putNum(){
        return this.num;
    }
    public String putName(){
        return this.name;
    }
    public int putMat(){
        return this.MatScore;
    }
    public int putChi(){
        return this.ChiScore;
    }
    public int putEng(){
        return this.EngScore;
    }
    public int putSum(){
        return this.SumScore;
    }
    public double putAve(){
        return this.AveScore;
    }
}
