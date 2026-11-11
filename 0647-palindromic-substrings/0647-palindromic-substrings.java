
import java.util.Arrays;

class Solution {
    int[][] t;

    public boolean check(String s, int i, int j) {

        if (i >= j) {
            return true;
        }

        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return (t[i][j] = check(s, i + 1, j - 1) ? 1 : 0) == 1;
        }

        t[i][j] = 0;
        return false;
    }

    public int countSubstrings(String s) {

        int n = s.length();

        t = new int[n][n];

        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (check(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }
}
