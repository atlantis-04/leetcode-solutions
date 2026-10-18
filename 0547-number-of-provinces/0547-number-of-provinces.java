class Solution {
    public void dfs(int i, boolean[] visited, int[][] connect){
        visited[i] = true;
        for(int j = 0;j<connect.length;j++){
            if(!visited[j] && connect[i][j] == 1){
                dfs(j, visited, connect);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int pro = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, isConnected);
                pro++;
            }
        }
        return pro;
    }
}