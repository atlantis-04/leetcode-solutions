
import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];

        // Store the last occurrence of each character
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();

        int L = 0;

        while (L < n) {
            int R = last[s.charAt(L) - 'a'];
            int maxReach = R;

            // Expand the current partition if needed
            for (int i = L; i <= maxReach; i++) {
                maxReach = Math.max(
                    maxReach,
                    last[s.charAt(i) - 'a']
                );
            }

            R = maxReach;

            // Store the partition length
            ans.add(R - L + 1);

            // Move to the next partition
            L = R + 1;
        }

        return ans;
    }
}
