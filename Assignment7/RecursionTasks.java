package Assignment7;

public class RecursionTasks {
    
    // method to calculate the sum of the digits from 1 to n
    public int sumRecursive(int n) {
        if (n <= 0) return n;
        return n + sumRecursive(n - 1);
    }

    // method to convert decimal num to binary
    public String decimalToBinary(int n) {
        if (n == 0) return "";
        return decimalToBinary(n / 2) + n % 2;
    }

    public static void main(String[] args) {
        RecursionTasks tasks = new RecursionTasks();

        // test sumRecursive
        int number = 5;
        System.out.println("Sum of digits from 1 to " + number + " is " + tasks.sumRecursive(number));

        // test decimalToBinary
        int decimalNumber = 10;
        String binaryRepresentation = tasks.decimalToBinary(decimalNumber);
        // handle special case where decimal is 0
        if (binaryRepresentation.isEmpty()) {binaryRepresentation = "0";
    }
        System.out.println("Binary representation of " + decimalNumber + " is " + binaryRepresentation);
    }
}
