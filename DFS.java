import java.util.*;

public class DFS {

    static void dfs(int v, boolean[] visited, List<List<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int u : adj.get(v))
            if (!visited[u])
                dfs(u, visited, adj);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // remove this line if graph is directed
        }

        boolean[] visited = new boolean[n];
        System.out.print("Enter starting vertex: ");
        int start = sc.nextInt();

        System.out.print("DFS Traversal: ");
        dfs(start, visited, adj);

        sc.close();
    }
}
