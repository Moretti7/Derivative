package com.filatov;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Derivative implements Function {
    private Expression expression;

    public double derivative(double x, double e) {
        double h = 0.1;
        double one = (f(x + h) - f(x - h))/(2*h);
        h *= 0.1;
        double two = (f(x + h) - f(x - h))/(2*h);
        double tmp;
        boolean ok;

        do{
            h *= 0.1;
            tmp = (f(x + h) - f(x - h))/(2*h);
            ok = (Math.abs(tmp - two) >= Math.abs(two - one)) ||
                    (Math.abs(two - one) < e);
            one = two;
            two = tmp;
        }while (!ok);

        return two;
    }

    public void setFunction(String function) {
        this.expression = new ExpressionBuilder(function).variables("x").build();
    }

    @Override
    public double f(double x) {
        return expression.setVariable("x", x).evaluate();
    }
}
