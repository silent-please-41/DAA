import java.util.Scanner;

public class HeapSortDemo {

    // Heapify a subtree
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // if left child is larger
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // if right child is larger
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // if root is not largest
        if (largest != i) {
            // swap
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function for Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify root
            heapify(arr, i, 0);
        }
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

        heapSort(arr);

        System.out.println("\n\nSorted Array (Heap Sort):");
        for (int i : arr) System.out.print(i + " ");

        System.out.println("\n\nTime Complexity of Heap Sort:");
        System.out.println("Best Case: O(n log n)");
        System.out.println("Worst Case: O(n log n)");
        System.out.println("Average Case: O(n log n)");
    }
}
