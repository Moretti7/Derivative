package com.filatov;

import com.filatov.charts.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileToPoints {
    private List<Point> points;

    public FileToPoints() {
        points = new LinkedList<>();
    }

    //    x: 123.123 y: 123.123
    public void readFromFile(String fileName) throws Exception {
        if (points.size() > 0)
            points.clear();

        String patternString = "\\s*x:\\s*(-?[0-9 \\. \\,]+)\\s+y:\\s*(-?[0-9 \\. \\,]+)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String data = null;

            while ((data = reader.readLine()) != null) {
                data = data.replace(',', '.');
                if ((matcher = pattern.matcher(data)).matches()) {
                    double x = Double.parseDouble(matcher.group(1));
                    double y = Double.parseDouble(matcher.group(2));

                    points.add(new Point(x, y));
                }
            }
        }

        Collections.sort(points);
    }

    public List<Point> getPoints(){
        return points;
    }

    public  List<Double> getXCords(){
        List<Double> xCords = new LinkedList<>();

        for (Point point : points){
            xCords.add(point.getX());
        }

        return xCords;
    }


    public  List<Double> getYCords(){
        List<Double> yCords = new LinkedList<>();

        for (Point point : points){
            yCords.add(point.getY());
        }

        return yCords;
    }
}
