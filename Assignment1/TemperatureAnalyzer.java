package Assignment1;

import java.util.Scanner;

// Charity Smith
// SD10
// 13 September 2024

// Calculate the avarage temperature, and give how many days are above the avarage temperature
// 1. Take an input from the user (eg. 5)2. Prompt the user to enter all the 5 numbers (temperature values)3. Calculate the avarage temperature
// 2. Given the avarage temperature, how many of the numbers in the line 2 are above the avarage temperature?

public class TemperatureAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get number of temperatures
        System.out.print("Enter the number of temperature values: ");
        int numTemps = scanner.nextInt(); 

        // get the temperatures
        double[] temps = new double[numTemps];
        double sum = 0;
        for (int i = 0; i < numTemps; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temps[i] = scanner.nextDouble();
            sum += temps[i];
        }

        // calculate the average
        double average = sum / numTemps;
        System.out.println("The average temperature is: %.2f\n" + average);

        // find the number of temperatures above the average
        int aboveAverageCount = 0;
        for (double temp : temps) {
            if (temp > average) {
                aboveAverageCount++;
            }
        }

        System.out.println("The number days above the average temperature is/are: " + aboveAverageCount);

        scanner.close();
    }
}