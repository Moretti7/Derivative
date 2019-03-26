package com.filatov.charts;

public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int compareTo(Point o) {
        return (int) (x - o.getX());
    }

    @Override
    public String toString() {
        return String.format("x: %f\ty: %f", x, y);
    }
}
