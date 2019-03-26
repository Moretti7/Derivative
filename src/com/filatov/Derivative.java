package com.filatov;

public class Derivative /*implements Function */{

//    private double parametrA;
    private Derivative(){}

    public static double derivative(Function function, double x, double e) {
        double h = 0.1;
        double one = (function.f(x + h) - function.f(x - h))/(2*h);
        h *= 0.1;
        double two = (function.f(x + h) - function.f(x - h))/(2*h);
        double tmp;
        boolean ok;

        do{
            h *= 0.1;
            tmp = (function.f(x + h) - function.f(x - h))/(2*h);
            ok = (Math.abs(tmp - two) >= Math.abs(two - one)) ||
                    (Math.abs(two - one) < e);
            one = two;
            two = tmp;
        }while (!ok);

        return two;
    }

//    public void setA(double a){
//        this.parametrA = a;
//    }


//    @Override
//    public double f(double x) {
//        return Math.exp(-parametrA*x*x)*Math.sin(x);
//    }

}
