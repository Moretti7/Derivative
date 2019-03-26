package com.filatov;

import com.filatov.charts.Point;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PointsToFile {
    public static void toFile(String fileName, List<Point> points) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)){
            for (Point point : points) {
                fileWriter.write(point.toString() + "\n");
            }
        }
    }
}
