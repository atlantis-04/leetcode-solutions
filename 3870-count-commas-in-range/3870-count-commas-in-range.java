class Solution {
    public int count(int n) {

        int digits = String.valueOf(n).length();
        int commas = (digits - 1) / 3;
        return commas;
    }

    public int countCommas(int n) {
        int total = 0;
        for (int i = 1000; i <= n; i++) {
            total += count(i);
        }
        return total;
    }
}