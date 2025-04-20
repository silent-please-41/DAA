import java.util.Scanner;

public class QuickSortDemo {

    // Quick Sort Function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // pivot index
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition Function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Original Array:");
        for (int i : arr) System.out.print(i + " ");

        quickSort(arr, 0, n - 1);

        System.out.println("\n\nSorted Array (Quick Sort):");
        for (int i : arr) System.out.print(i + " ");

        System.out.println("\n\nTime Complexity of Quick Sort:");
        System.out.println("Best Case: O(n log n)");
        System.out.println("Worst Case: O(n^2) [when array is already sorted]");
        System.out.println("Average Case: O(n log n)");
    }
}
