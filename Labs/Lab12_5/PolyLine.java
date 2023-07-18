package Lab12_5;

import java.util.ArrayList;
import java.util.List;

class PolyLine {
    private List<Point> points;

    public PolyLine() {
        points = new ArrayList<>();
    }

    public PolyLine(List<Point> p) {
        points = p;
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public double getLength() {
        double length = 0;
        int x1, x2, y1, y2;
        for (int i = 0; i < (points.size() - 1); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            x1 = p1.getX();
            x2 = p2.getX();
            y1 = p1.getY();
            y2 = p2.getY();
            length += Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
        return length;
    }
}
