package Task4;

import java.util.Scanner;

class Matrix {
    private int[][] data;
    private int size;

    public Matrix(int n) {
        size = n;
        data = new int[n][n];
    }

    public void setElement(int i, int j, int value) {
        data[i][j] = value;
    }

    public void processDiagonals() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // main diagonal: i == j
                // secondary diagonal: i + j == size - 1
                if (i == j || i + j == size - 1) {
                    data[i][j] = 0;
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(data[i][j]);
                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

public class task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Matrix matrix = new Matrix(n);

        // input matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = sc.nextInt();
                matrix.setElement(i, j, val);
            }
        }

        // process and print
        matrix.processDiagonals();
        matrix.printMatrix();

        sc.close();
    }
}