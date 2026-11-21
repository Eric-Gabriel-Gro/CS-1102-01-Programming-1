import java.util.Locale;
import java.util.Scanner;

public class StudentReportQ3 {
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
        char grade = calculateGrade(average);

        String description;
        switch (grade) {
            case 'A':
                description = "Excellent performance";
                break;
            case 'B':
                description = "Very good performance";
                break;
            case 'C':
                description = "Satisfactory performance";
                break;
            default:
                description = "Unsatisfactory performance";
                break;
        }

        System.out.printf("%n============== STUDENT RESULT ==============%n"
                        + "Total marks : %.2f out of %d%n"
                        + "Average     : %.2f%n"
                        + "Grade       : %c (%s)%n"
                        + "============================================%n",
                total, marks.length * 100, average, grade, description);
    }
}