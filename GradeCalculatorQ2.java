import java.util.Locale;
import java.util.Scanner;

public class GradeCalculatorQ2 {
    public static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else {
            return 'F';
        }
    }

    public static char calculateGrade(double total, int numberOfSubjects) {
        return calculateGrade(total / numberOfSubjects);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        double[] marks = new double[5];

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark_subject_" + (i + 1) + " (0-100): ");
            double mark = input.hasNextDouble() ? input.nextDouble() : -1;
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid input - Marks must be between 0 and 100 (inclusive)");
                System.exit(1);
            }
            marks[i] = mark;
        }
        input.close();

        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        double average = total / marks.length;

        System.out.println();
        System.out.println("----- Results -----");
        System.out.printf("Total marks          : %.2f out of %d%n", total, marks.length * 100);
        System.out.printf("Average marks        : %.2f%n", average);
        System.out.println("Grade (from average) : " + calculateGrade(average));
        System.out.println("Grade (from total)   : " + calculateGrade(total, marks.length));
    }
}