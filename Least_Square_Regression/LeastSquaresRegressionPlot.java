import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeastSquaresRegressionPlot extends JPanel {

    private ArrayList<Point> points;
    private int n;
    private double a;
    private double b;

    public LeastSquaresRegressionPlot(ArrayList<Point> points) {
        this.points = points;
        this.n = points.size();
        calculateRegressionLine();
    }

    private void calculateRegressionLine() {
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for (Point p : points) {
            sumX += p.x;
            sumY += p.y;
            sumXY += p.x * p.y;
            sumX2 += p.x * p.x;
        }

        a = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        b = (sumY - a * sumX) / n;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        for (Point p : points) {
            g.fillOval(p.x - 2, p.y - 2, 4, 4);
        }

        int x1 = 0;
        int y1 = (int) (a * x1 + b);
        int x2 = getWidth();
        int y2 = (int) (a * x2 + b);

        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
    }
}

