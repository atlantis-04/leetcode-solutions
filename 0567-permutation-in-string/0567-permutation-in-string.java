import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // Frequency of s1
        for (int k = 0; k < n; k++) {
            s1Freq[s1.charAt(k) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while (j < m) {

            // Add right character
            s2Freq[s2.charAt(j) - 'a']++;

            // If window becomes larger than s1
            if (j - i + 1 > n) {
                s2Freq[s2.charAt(i) - 'a']--;
                i++;
            }

            // Compare frequency arrays
            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }

            j++;
        }

        return false;
    }
}