import java.io.*;
import java.util.*;

public class InsertionSortFromFile {

    // Function to read numbers from a file into an array
    public static int[] readNumbersFromFile(String filename) throws IOException {
        List<Integer> numberList = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(filename));

        while (fileScanner.hasNextInt()) {
            numberList.add(fileScanner.nextInt());
        }
        fileScanner.close();

        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }
        return numbers;
    }

    // Function to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        try {
            String filename = "data.txt"; // Make sure this file exists
            int[] arr = readNumbersFromFile(filename);

            System.out.println("Original array:");
            System.out.println(Arrays.toString(arr));

            insertionSort(arr);

            System.out.println("\nSorted array (Ascending order):");
            System.out.println(Arrays.toString(arr));

            // Time complexity explanation
            System.out.println("\nTime Complexity of Insertion Sort:");
            System.out.println("Best Case: O(n)      → Already sorted");
            System.out.println("Worst Case: O(n^2)   → Reverse order");
            System.out.println("Average Case: O(n^2) → Random order");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
