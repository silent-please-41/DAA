import java.io.*;
import java.util.*;

public class BinarySearchFromFile {

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

    // Binary Search Function (array must be sorted)
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            String filename = "data.txt";
            int[] numbers = readNumbersFromFile(filename);

            Arrays.sort(numbers); // Make sure the array is sorted

            System.out.println("Sorted array: " + Arrays.toString(numbers));

            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number to search: ");
            int key = input.nextInt();

            int index = binarySearch(numbers, key);

            if (index != -1) {
                System.out.println(key + " found at index " + index);
            } else {
                System.out.println(key + " not found in the array.");
            }

            // Time complexity explanation
            System.out.println("\nTime Complexity of Binary Search:");
            System.out.println("Best Case: O(1)  → Key is at the middle");
            System.out.println("Worst Case: O(log n)  → Key not present or at edge");
            System.out.println("Average Case: O(log n)");

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
