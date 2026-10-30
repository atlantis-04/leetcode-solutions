
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];
        int INF = (int) 1e8;

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] != INF &&
                        dist[via][j] != INF) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][via] + dist[via][j]
                        );
                    }
                }
            }
        }

        int minCount = n;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            // <= ensures larger city index wins ties
            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }
}
