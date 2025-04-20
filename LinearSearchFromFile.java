import java.io.*;
import java.util.*;

public class LinearSearchFromFile {

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

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            String filename = "data.txt";
            int[] numbers = readNumbersFromFile(filename);

            System.out.println("Array from file: " + Arrays.toString(numbers));

            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number to search: ");
            int key = input.nextInt();

            int index = linearSearch(numbers, key);

            if (index != -1) {
                System.out.println(key + " found at index " + index);
            } else {
                System.out.println(key + " not found in the array.");
            }

            System.out.println("\nTime Complexity Analysis:");
            System.out.println("Best Case: O(1)");
            System.out.println("Worst Case: O(n)");
            System.out.println("Average Case: O(n)");

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
