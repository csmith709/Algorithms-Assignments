package Assignment2;

// Charity Smith
// SD10
// 16/09/2024
// This program is a double dimensional array that can insert, transverse, search, and delete values in the array.

public class DoubleDimention {
    private int[][] arr = null;

    // Initialize the array
    public DoubleDimention(int numberOfRows, int numberOfColumns) {
        arr = new int[numberOfRows][numberOfColumns];

        // Initialize all elements to 0
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0; // You might use Integer.MIN_VALUE to indicate 'empty' if preferred
            }
        }
    }

    // Insert Method
    public void insert(int valueToInsert, int row, int column) {
        try {
            if (arr[row][column] == 0) { // Assuming 0 is the 'empty' indicator
                arr[row][column] = valueToInsert;
                System.out.println("Value inserted successfully");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: out of bounds");
        }
    }

    // Transverse Method
    public void transverse() {
        if (arr == null) {
            System.out.println("Array does not exist");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Search Method
    public void searchArray(int valueToSearch) {
        if (arr == null) {
            System.out.println("Array does not exist");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    System.out.println("Value found at row " + i + " and column " + j);
                    return;
                }
            }
        }
        System.out.println("Value not found");
    }

    // Delete Method
    public void deleteValue(int row, int column) {
        try {
            if (arr[row][column] != 0) { // Assuming 0 is the 'empty' indicator
                arr[row][column] = 0; // Reset to 'empty' value
                System.out.println("Value deleted successfully");
            } else {
                System.out.println("This cell is already empty");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: out of bounds");
        }
    }

    public void deleteArray() {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = 0; // Resetting before deletion (optional)
                }
            }
            arr = null;
            System.out.println("Array deleted successfully");
        } else {
            System.out.println("Array does not exist");
        }
    }

    public static void main(String[] args) {
        DoubleDimention dd = new DoubleDimention(3, 3);
        // Insert values
        dd.insert(1, 0, 0);
        dd.insert(2, 0, 1);
        dd.insert(3, 0, 2);
        dd.insert(4, 1, 0);
        dd.insert(5, 1, 1);
        dd.insert(6, 1, 2);
        dd.insert(7, 2, 0);
        dd.insert(8, 2, 1);
        dd.insert(9, 2, 2);

        // Transverse the array
        dd.transverse();

        // Search for a value
        dd.searchArray(5);

        // Delete a value
        dd.deleteValue(1, 1);
        dd.transverse();

        // Delete the entire array
        dd.deleteArray();
        dd.transverse();
    }
}
