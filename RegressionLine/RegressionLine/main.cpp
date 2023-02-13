#include <vector>
#include <iostream>
#include <cmath>
#include <fstream>
#include <algorithm>

using namespace std;

class Point {
 public:
  Point(double x, double y) : x(x), y(y) {}
  double x, y;
};

class LeastSquaresRegression {
 public:
  LeastSquaresRegression(const vector<Point>& points) : points(points) {
    n = points.size();
    CalculateRegressionLine();
  }

  void SavePlotToFile(const string& fileName) {
    ofstream file;
    file.open(fileName);

    double minX = points[0].x;
    double maxX = points[0].x;
    for (const auto& point : points) {
      minX = min(minX, point.x);
      maxX = max(maxX, point.x);
    }

    double step = (maxX - minX) / 100;
    for (double x = minX; x < maxX; x += step) {
      double y = a * x + b;
      file << x << " " << y << endl;
    }

    file.close();
  }

 private:
  void CalculateRegressionLine() {
    double sumX = 0;
    double sumY = 0;
    double sumXY = 0;
    double sumX2 = 0;

    for (const auto& point : points) {
      sumX += point.x;
      sumY += point.y;
      sumXY += point.x * point.y;
      sumX2 += point.x * point.x;
    }

    a = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    b = (sumY - a * sumX) / n;
  }

  vector<Point> points;
  int n;
  double a, b;
};

int main() {
  vector<Point> points = {{100, 150}, {200, 200}, {300, 250}, {400, 300}};
  LeastSquaresRegression regression(points);
  regression.SavePlotToFile("regression_plot.txt");
  return 0;
}

