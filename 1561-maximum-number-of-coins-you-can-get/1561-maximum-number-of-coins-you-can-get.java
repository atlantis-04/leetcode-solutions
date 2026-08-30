class Solution {
    public int maxCoins(int[] piles) {
        // n steps
        int n = piles.length;
        int ans = 0;
        Arrays.sort(piles);
        for(int i = n / 3; i < n; i += 2){
            ans += piles[i];
        }
        return ans;
    }
}