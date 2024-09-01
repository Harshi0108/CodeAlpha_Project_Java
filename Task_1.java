import java.util.*;

class Task_1 {
    public static void main(String[] args) {
        // Getting number of student 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int students = sc.nextInt();
        // Getting number of grade that teacher want
        System.out.println("Enter the number of grades per student:");
        int numGrade = sc.nextInt();
        //running loop upto students count
        for (int i = 1; i <= students; i++) {
            double total = 0;
            double[] grades = new double[numGrade];

            System.out.println("Entering grades for Student " + i);

            // Initialize highest and lowest outside the loop
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.POSITIVE_INFINITY;

            // Input grades and calculate total, highest, and lowest grade
            for (int j = 0; j < numGrade; j++) {
                System.out.println("Enter Grade " + (j + 1) + ":");
                grades[j] = sc.nextDouble();
                total += grades[j];

                // Determine highest and lowest grade
                if (grades[j] > highest) {
                    highest = grades[j];
                }
                if (grades[j] < lowest) {
                    lowest = grades[j];
                }
            }

            double average = total / numGrade;

            // Output results for this student
            System.out.println("Total for Student " + i + ": " + total);
            System.out.println("Average for Student " + i + ": " + average);
            System.out.println("Highest grade for Student " + i + ": " + highest);
            System.out.println("Lowest grade for Student " + i + ": " + lowest);
        }

        sc.close();
    }
}