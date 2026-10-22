
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < n; i++) {

//          increasing order
            if (nums[(p + i) % n] != i) {
                inc = false;
            }

//          decreasing order
            if (nums[(p - i + n) % n] != i) {
                dec = false;
            }
        }

        int ans = Integer.MAX_VALUE;
// increasing decreasing me se koi ek hi possible hai 
        if (inc) {
            //                          left half ya right half
            ans = Math.min(ans, Math.min(p, n - p + 2));
        }

        if (dec) {
            ans = Math.min(ans, Math.min(n - p, p + 2));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
