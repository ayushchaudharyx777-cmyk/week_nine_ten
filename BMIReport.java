import java.util.Scanner;

public class BMIReport {

    // Method to calculate BMI and status
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }

        return result;
    }

    // Display method
    public static void display(String[][] arr) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1] + "\t\t" + arr[i][2] + "\t" + arr[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];

        // Input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            data[i][0] = sc.nextDouble();

            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = calculateBMI(data);
        display(result);

        sc.close();
    }
}