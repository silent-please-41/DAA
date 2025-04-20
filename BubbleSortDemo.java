import java.util.Scanner;

public class BubbleSortDemo {

    // Function to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if necessary
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps happened, array is already sorted
            if (!swapped) {
                break;
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

        bubbleSort(arr);

        System.out.println("\n\nSorted array (Ascending order):");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Time complexity explanation
        System.out.println("\n\nTime Complexity of Bubble Sort:");
        System.out.println("Best Case: O(n)      → Array is already sorted");
        System.out.println("Worst Case: O(n^2)   → Array is in reverse order");
        System.out.println("Average Case: O(n^2) → Random order");
    }
}
