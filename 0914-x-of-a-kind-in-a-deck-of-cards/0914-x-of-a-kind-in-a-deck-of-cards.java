class Solution {
    public boolean hasGroupsSizeX(int[] deck) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each card
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find GCD of all frequencies
        int gcd = 0;

        for (int freq : map.values()) {
            gcd = gcd(gcd, freq);
        }

        return gcd >= 2;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}