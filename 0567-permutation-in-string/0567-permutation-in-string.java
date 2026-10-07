import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is longer than s2, impossible
        if (n > m) return false;

        // Sort s1
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        // Check every substring of s2 having length n
        for (int i = 0; i <= m - n; i++) {

            String temp = s2.substring(i, i + n);

            // Sort substring
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            temp = new String(tempArr);

            // Compare strings
            if (temp.equals(sortedS1)) {
                return true;
            }
        }

        return false;
    }
}