class Solution {
    public boolean canAliceWin(int n) {
        int c = 10;
        boolean f = true;

        while (n >= c) {
            n -= c;
            c--;
            f = !f;
        }

        return !f;
    }
}