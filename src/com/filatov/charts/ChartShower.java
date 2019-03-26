package com.filatov.charts;

import com.filatov.FileToPoints;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class ChartShower {
    private ChartShower() {}

    public static void showChart(FileToPoints fileToPoints){
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", fileToPoints.getXCords(), fileToPoints.getYCords());
        new SwingWrapper(chart).displayChart();
    }
}
