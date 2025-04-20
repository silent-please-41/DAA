import java.util.PriorityQueue;

class OptimalMergePattern {

    public static int optimalMergeCost(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int file : files) {
            pq.add(file);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int firstMin = pq.poll();
            int secondMin = pq.poll();

            int mergedCost = firstMin + secondMin;
            totalCost += mergedCost;

            pq.add(mergedCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] files = { 4, 2, 7, 8, 5 }; // Example file sizes
        int cost = optimalMergeCost(files);
        System.out.println("Optimal merge cost: " + cost);
    }
}
