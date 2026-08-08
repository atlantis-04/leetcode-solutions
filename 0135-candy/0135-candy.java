import java.util.*;

class Solution {
    // Function to calculate the minimum number of candies 
    public int candy(int[] ratings) {
        int n = ratings.length;

        // Array to store candies given to each child, initialized to 1
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        boolean updated = true;

        // Loop until no changes are made in one full pass
        while (updated) {
            updated = false;

            // Left to right pass
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    updated = true;
                }
            }

            // Right to left pass
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    updated = true;
                }
            }
        }

        // Sum up the total candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }
}
