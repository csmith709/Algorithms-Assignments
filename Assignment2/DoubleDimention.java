package Assignment2;

// Charity Smith
// SD10
// 16/09/2024
// This program is a double dimentional array that can insert, transverse, search, and delete values in the array.

public class DoubleDimention {
    static int[][] arr = null;

    // Insert
    // Transverse
    // Delete (specific and entirity)
    // Search

    // initialize the array
    public DoubleDimention(int numberOfRows, int numberOfColumns) {
        arr = new int[numberOfRows][numberOfColumns];

    // initialize all elements to 0
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = 0;
        }
    }
    }


    // Insert Method
    public void insert(int valueToInsert, int row, int column) {
        try {
            if (arr[row][column] == Integer.MIN_VALUE) {
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
        try {
            for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    } catch (NullPointerException e) {
        System.out.println("Array does not exist");
    }
    }

    // Search Method
    public static void searchArray(int valueToSearch) {
        try {
            for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    System.out.println("Value found at row " + i + " and column " + j);
                    return;
                }
            }
        }
        System.out.println("Value not found at row: \" + i + \", column: \" + j");
    } catch (NullPointerException e) {
        System.out.println("Value not found");
    }
    }

    // Delete Method
    public static void deleteValue(int row, int column) {
        try {
            if (arr[row][column] != Integer.MIN_VALUE) {
            arr[row][column] = Integer.MIN_VALUE;
            System.out.println("Value deleted successfully");
        } else {
            System.out.println("This cell is already empty");
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid index: out of bounds");
    }
    }

    public static void deleteArray() {
        arr = null;
        System.out.println("Array deleted successfully");
    }

    public static void main(String[] args) {
        DoubleDimention dd = new DoubleDimention(3, 3);
        // insert values
        dd.insert(1, 0, 0);
        dd.insert(2, 0, 1);
        dd.insert(3, 0, 2);
        dd.insert(4, 1, 0);
        dd.insert(5, 1, 1);
        dd.insert(6, 1, 2);
        dd.insert(7, 2, 0);
        dd.insert(8, 2, 1);
        dd.insert(9, 2, 2);

        // transverse the array
        dd.transverse();

        // search for a value
        searchArray(5);

        // delete a value
        deleteValue(1, 1);
        dd.transverse();

        // delete the entire array
        deleteArray();
        dd.transverse();
    }

}
