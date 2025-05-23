import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight, profit;
    double density;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.density = (double) profit / weight;
    }
}

public class FractionalKnapsackByDensity {

    public static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return Double.compare(i2.density, i1.density);
            }
        });

        double totalProfit = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalProfit += item.profit;
            } else {
                int remaining = capacity - currentWeight;
                totalProfit += item.density * remaining;
                break;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and profit for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = sc.nextInt();
            System.out.print("Item " + (i + 1) + " - Profit: ");
            int profit = sc.nextInt();
            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxProfit = fractionalKnapsack(items, capacity);

        System.out.println("\nMaximum Profit (Fractional Knapsack using Greedy by Density): " + maxProfit);
    }
}
