package study9_26;

public class Complex {
    private double real;
    private double ima;
    Complex(double real,double ima){
        this.real=real;
        this.ima=ima;
    }

    public double getReal(){
        return this.real;
    }
    public double getIma(){
        return this.ima;
    }

    public Complex Add(Complex b){
        return new Complex(this.real+b.real,this.ima+b.ima);
    }
    public Complex Min(Complex b){
        return new Complex(this.real-b.real,this.ima-b.ima);
    }
}
