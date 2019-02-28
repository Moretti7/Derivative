package com.filatov;

public class Derivative {
    public static double derivative(double x, double e, Function f) {
        double h = 0.1;
        double one = (f.f(x + h) - f.f(x - h))/(2*h);
        h *= 0.1;
        double two = (f.f(x + h) - f.f(x - h))/(2*h);
        double tmp;
        boolean ok;

        do{
            h *= 0.1;
            tmp = (f.f(x + h) - f.f(x - h))/(2*h);
            ok = (Math.abs(tmp - two) >= Math.abs(two - one)) ||
                    (Math.abs(two - one) < e);
            one = two;
            two = tmp;
        }while (!ok);

        return two;
    }


    //x^3 = 3*x*x
    public static void main(String[] args) {
        System.out.println(derivative(5, 0.0000000000000001, x -> x*x*x));
    }
}
