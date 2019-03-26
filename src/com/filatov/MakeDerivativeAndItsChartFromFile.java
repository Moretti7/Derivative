package com.filatov;

import com.filatov.charts.ChartShower;
import com.filatov.charts.Point;
import com.filatov.interpolation.InterpolationSearch;

import java.util.LinkedList;
import java.util.List;

public class MakeDerivativeAndItsChartFromFile {
    public static void main(String[] args) throws Exception {
        FileToPoints fileToPoints = new FileToPoints();
        fileToPoints.readFromFile("points.txt");
        InterpolationSearch interpolationSearch = new InterpolationSearch(fileToPoints.getPoints());

        List<Point> derivativePoints = new LinkedList<>();
        for (Point point : fileToPoints.getPoints()) {
            Point newPoint = new Point(point.getX(), Derivative.derivative(interpolationSearch, point.getX(), 0.0000000000000000000001));
//            System.out.println(">>> " + newPoint);
            derivativePoints.add(newPoint);
        }

        PointsToFile.toFile("result.txt", derivativePoints);

        fileToPoints.readFromFile("result.txt");

//        for (Point point : fileToPoints.getPoints()) {
//            System.out.println(point);
//        }
        ChartShower.showChart(fileToPoints);
    }
}
