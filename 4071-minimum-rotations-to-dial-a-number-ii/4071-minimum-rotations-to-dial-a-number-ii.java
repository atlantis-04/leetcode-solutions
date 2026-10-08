
class Solution {

    // Minimum rotations between two digits
    int distance(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }

    public int minRotations(int n, String s) {

        int total = 0;
        int prev = 0;

        // Original rotation cost
        for (int i = 0; i < n; i++) {
            int curr = s.charAt(i) - '0';

            total += distance(prev, curr);
            prev = curr;
        }

        int ans = total;
        int last = s.charAt(n - 1) - '0';

        // Try reversing each suffix
        for (int k = 0; k < n; k++) {

            int before = (k == 0) ? 0 : s.charAt(k - 1) - '0';
            int first = s.charAt(k) - '0';

            int oldCost = distance(before, first);
            int newCost = distance(before, last);

            int newTotal = total - oldCost + newCost;

            ans = Math.min(ans, newTotal);
        }

        return ans;
    }
}
