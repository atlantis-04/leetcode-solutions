class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        // Max possible LCM for values 1..10 is 2520; max possible GCD is 10.
        int maxPossible = 2520 * 10;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int g = 0;
            int l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > maxPossible) {
                    break;
                }

                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (prod == g * l) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}