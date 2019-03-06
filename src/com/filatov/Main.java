package com.filatov;

public class Main {
    //x^3 = 3*x*x
    public static void main(String[] args) {
        Derivative derivative = new Derivative();
        derivative.setA(0.5);
        for(double x = 1.5; x < 6.5; x+= 0.05){
            System.out.printf("x = %f f\' = %f\n", x, derivative.derivative(x,0.00000000000000001));
        }
    }
}
