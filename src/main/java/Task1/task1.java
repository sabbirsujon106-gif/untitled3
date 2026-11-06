package Task1;

import java.util.Scanner; // Scanner er jonno eta lagbe

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}

public class task1 {

    public static void findLargest(Circle[] circles) {
        if (circles.length == 0) return;

        int maxRadius = circles[0].getRadius();
        int count = 1;

        for (int i = 1; i < circles.length; i++) {
            int currentRadius = circles[i].getRadius();

            if (currentRadius > maxRadius) {
                maxRadius = currentRadius;
                count = 1;
            } else if (currentRadius == maxRadius) {
                count++;
            }
        }

        System.out.println(maxRadius + " - " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Circle[] circles = new Circle[n];

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            circles[i] = new Circle(r);
        }

        findLargest(circles);

        sc.close();
    } // <-- eta main er close bracket
} // <-- eta class er close bracket