package Task3;

import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private int studentNumber;
    private int[] grades;

    public Student(int studentNumber, int[] grades) {
        this.studentNumber = studentNumber;
        this.grades = grades;
    }

    public double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public boolean hasGradeBelow5() {
        for (int grade : grades) {
            if (grade < 5) {
                return true;
            }
        }
        return false;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
}

public class task3 {

    public static void analyze(Student[] students, int subjects) {
        double groupSum = 0;
        double[] studentAverages = new double[students.length];
        double maxAvg = 0;

        System.out.println("Student averages:");

        // 1. Each student's average
        for (int i = 0; i < students.length; i++) {
            double avg = students[i].getAverage();
            studentAverages[i] = avg;
            groupSum += avg * subjects; // total all grades
            System.out.printf("%.0f\n", avg);
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        // 2. Group average
        double groupAvg = groupSum / (students.length * subjects);
        System.out.println("\nGroup average:");
        System.out.printf("%.2f\n", groupAvg);

        // 3. Highest-performing student
        System.out.println("\nHighest-performing student:");
        for (int i = 0; i < students.length; i++) {
            if (studentAverages[i] == maxAvg) {
                System.out.println(students[i].getStudentNumber());
            }
        }

        // 4. Students with grade below 5
        System.out.println("\nStudents with at least one grade below 5:");
        ArrayList<Integer> lowStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.hasGradeBelow5()) {
                lowStudents.add(s.getStudentNumber());
            }
        }

        if (lowStudents.isEmpty()) {
            System.out.println("None");
        } else {
            for (int num : lowStudents) {
                System.out.println(num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subjects = sc.nextInt();
        int numStudents = sc.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            int[] grades = new int[subjects];
            for (int j = 0; j < subjects; j++) {
                grades[j] = sc.nextInt();
            }
            students[i] = new Student(i + 1, grades); // student number starts from 1
        }

        analyze(students, subjects);

        sc.close();
    }
}