package com.filatov;

import java.util.Scanner;

public class Main {
    //x^3 = 3*x*x
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Derivative derivative = new Derivative();
        while (true){
            System.out.print("Enter the function: ");
            String function = scanner.nextLine();
            if(function.equals("close"))
                break;
            System.out.print("Enter x value: ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter E vlaue: ");
            double e = Double.parseDouble(scanner.nextLine());

            derivative.setFunction(function);
            System.out.println(derivative.derivative(x, e));
        }
    }
}
