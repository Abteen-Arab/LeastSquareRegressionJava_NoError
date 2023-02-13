import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class main{
    public static void main(String[] args) {
        //List Of Points
        ArrayList<Point> points = new ArrayList<>();
        //Adding the individual points
        points.add(new Point(100, 150));
        points.add(new Point(140, 230));
        points.add(new Point(300, 140));
        points.add(new Point(700, 200));
        //Setting the console output
        JFrame frame = new JFrame("Least Squares Regression Plot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 20);
        frame.add(new LeastSquaresRegressionPlot(points));
        frame.setVisible(true);
    }
}
