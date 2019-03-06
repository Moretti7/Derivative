package com.filatov;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;

public class DerivativeFromConsole extends Derivative {
    private Expression expression;

    public DerivativeFromConsole(String function){
        this.expression = new ExpressionBuilder(function).variables("x").build();
    }

    @Override
    public double f(double x) {
        return expression.setVariable("x", x).evaluate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Enter the function: ");
            String function = scanner.nextLine();
            if(function.equals("close"))
                break;
            Derivative derivative = new DerivativeFromConsole(function);
            System.out.print("Enter x value: ");
            double x = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter E value: ");
            double e = Double.parseDouble(scanner.nextLine());

            System.out.println(derivative.derivative(x, e));
        }
    }
}
