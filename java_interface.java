import java.util.Scanner;
// 1. Interface (Blueprint - Cannot be run directly)
interface Transformations {
    void translate(double tx, double ty);
    void scale(double sx, double sy);
    void rotate(double angle);
}
// 2. Implementation Class
class Point implements Transformations {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void translate(double tx, double ty) {
        x += tx;
        y += ty;
    }
    public void scale(double sx, double sy) {
        x *= sx;
        y *= sy;
    }
    public void rotate(double angle) {
        double rad = Math.toRadians(angle);
        double newX = x * Math.cos(rad) - y * Math.sin(rad);
        double newY = x * Math.sin(rad) + y * Math.cos(rad);
        x = newX;
        y = newY;
    }
    double calculate(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    void display() {
        System.out.printf("Point (%.2f, %.2f)%n", x, y);
    }
}
public class transform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of points: ");
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point(x, y);
        }
        for(int i = 0; i < n; i++) {
            System.out.println("\n--- Processing Point " + (i + 1) + " ---");
            points[i].display();
            points[i].translate(2, 3);
            System.out.print("After Translation: ");
            points[i].display();
            points[i].scale(2, 2);
            System.out.print("After Scaling: ");
            points[i].display();
            points[i].rotate(45);
            System.out.print("After Rotation: ");
            points[i].display();
        }
        if(n >= 2) {
            // FIXED: Reference the array indices properly
            double dist = points[0].calculate(points[1]);
            System.out.printf("\nDistance between Point 1 and Point 2: %.4f%n", dist);
        }
        sc.close();
    }
}

