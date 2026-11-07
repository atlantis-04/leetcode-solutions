class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int q = queries.length;
        int[][] sq = new int[q][2];
        for(int i=0;i<q;i++){
            sq[i][0]=queries[i];
            sq[i][1]=i;
        }
        Arrays.sort(sq,(a,b)->a[0]-b[0]);
        int[] freq = new int[n+1];
        int[] ans = new int[q];
        int left=0,right=0;
        int active=0;
        for(int[]qry:sq){
            int start = qry[0]-x;
            int end = qry[0];
            int idx = qry[1];
            while(right<logs.length && logs[right][1]<=end){
                int id = logs[right][0];
                if(freq[id]==0)active++;
                freq[id]++;
                right++;
            }
            while(left<right && logs[left][1]<start){
                int id = logs[left][0];
                freq[id]--;
                if(freq[id]==0)active--;
                left++;
            }
            ans[idx] = n-active;
        }
        return ans;
    }
}