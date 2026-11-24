import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] size;
    private int[] lastSeen;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.adj = new ArrayList[n];
        this.size = new int[n];
        this.lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        dfs(0, -1);
        return size;
    }

    private void dfs(int u, int origParent) {
        int ch = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[ch];

        // Determine the new parent in the final tree
        int newParent = (prevAncestor != -1) ? prevAncestor : origParent;

        // Track current node as the most recent ancestor for this character
        lastSeen[ch] = u;
        size[u] = 1;

        for (int v : adj[u]) {
            dfs(v, u);
        }

        // Backtrack: restore the previous ancestor for this character
        lastSeen[ch] = prevAncestor;

        // Propagate this node's final subtree size up to its new parent
        if (newParent != -1) {
            size[newParent] += size[u];
        }
    }
}