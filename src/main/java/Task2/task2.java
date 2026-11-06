package Task2;

import java.util.Scanner;

class House {
    private int houseNumber;
    private int residents;

    public House(int houseNumber, int residents) {
        this.houseNumber = houseNumber;
        this.residents = residents;
    }

    public int getResidents() {
        return residents;
    }

    public boolean isLeftSide() {
        return houseNumber % 2 != 0; // odd = left
    }

    public boolean isRightSide() {
        return houseNumber % 2 == 0; // even = right
    }
}

public class task2 {

    public static void calculate(House[] houses) {
        int total = 0;
        int leftTotal = 0;
        int rightTotal = 0;
        int leftCount = 0;
        int rightCount = 0;

        for (House house : houses) {
            int res = house.getResidents();
            total += res;

            if (house.isLeftSide()) {
                leftTotal += res;
                leftCount++;
            } else {
                rightTotal += res;
                rightCount++;
            }
        }

        System.out.println("Total residents: " + total);
        System.out.println("Residents on the left: " + leftTotal);
        System.out.println("Residents on the right: " + rightTotal);

        if (leftCount > 0) {
            double leftAvg = (double) leftTotal / leftCount;
            System.out.printf("Average per house on the left: %.0f\n", leftAvg);
        } else {
            System.out.println("Average per house on the left: N/A");
        }

        if (rightCount > 0) {
            double rightAvg = (double) rightTotal / rightCount;
            System.out.printf("Average per house on the right: %.0f\n", rightAvg);
        } else {
            System.out.println("Average per house on the right: N/A");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        House[] houses = new House[n];

        for (int i = 0; i < n; i++) {
            int residents = sc.nextInt();
            houses[i] = new House(i + 1, residents); // house number 1 to n
        }

        calculate(houses);

        sc.close();
    }
}