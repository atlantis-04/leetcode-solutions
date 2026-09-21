class Solution {

    public boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {

        int n = p.length();
        int m = s.length();

        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        prev[0] = true;

        for (int i = 1; i <= n; i++) {

            curr[0] = isAllStars(p, i);

            for (int j = 1; j <= m; j++) {

                char pChar = p.charAt(i - 1);
                char sChar = s.charAt(j - 1);

                if (pChar == sChar || pChar == '?') {
                    curr[j] = prev[j - 1];
                } else if (pChar == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }

            boolean[] temp = prev;
            prev = curr;
            curr = temp;
            Arrays.fill(curr, false);
        }

        return prev[m];
    }
}