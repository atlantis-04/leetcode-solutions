class Solution {
    int[][] cost;
    int[][] dp;
    int n;
    int INF=1000000000;
    public int minimumChanges(String s, int k) {
        n=s.length();
        cost=new int[n][n];
        dp=new int[n][k+1];
        for (int[] row:dp) {
            Arrays.fill(row, -1);
        }
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                cost[i][j]=getCost(s,i,j);
            }
        }
        return solve(0,k);
    }
    public int solve(int i,int k) {
        if (k==0) {
            return i==n?0:INF;
        }
        if (n-i<2*k)return INF;
        if (dp[i][k]!=-1)return dp[i][k];
        int min=INF;
        for (int j=i+1;j<=n-2*(k-1)-1;j++){
            int changes=cost[i][j]+solve(j+1,k-1);
            min=Math.min(min,changes);
        }
        return dp[i][k]=min;
    }
    public int getCost(String s,int i,int j){
        int len=j-i+1;
        int min=INF;
        for (int d=1;d<len;d++){
            if (len%d!=0)continue;
            int changes=0;
            for (int start=0;start<d;start++){
                int l=i+start;
                int r=i+start+len-d;
                while (l<r){
                    if (s.charAt(l)!=s.charAt(r)) {
                        changes++;
                    }
                    l+=d;
                    r-=d;
                }
            }
            min=Math.min(min,changes);
        }
        return min;
    }
}