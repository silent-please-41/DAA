import java.util.Scanner;

public class SelectionSortDemo {

    // Function to perform Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first element
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\n\nSorted array (Ascending order):");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Time complexity analysis
        System.out.println("\n\nTime Complexity of Selection Sort:");
        System.out.println("Best Case: O(n^2)");
        System.out.println("Worst Case: O(n^2)");
        System.out.println("Average Case: O(n^2)");
    }
}
