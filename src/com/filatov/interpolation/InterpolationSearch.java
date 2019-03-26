package com.filatov.interpolation;

import com.filatov.Function;
import com.filatov.charts.Point;

import java.util.List;

public class InterpolationSearch implements Function {
    private List<Point> points;

    public InterpolationSearch (List<Point> points) {
        this.points = points;
    }

    @Override
    public double f(double x) {
        double res = 0.0;
        int numData = points.size();
        double numer, denom;

        for (int k = 0; k < numData; k++) {
            numer = 1.0;
            denom = 1.0;
            for (int j = 0; j < numData; j++) {
                if (j != k) {
                    numer = numer * (x - points.get(j).getX());
                    denom = denom * (points.get(k).getX() - points.get(j).getX());
                }
            }
            res = res + points.get(k).getY()*numer/denom;
        }

        return res;
    }
}
