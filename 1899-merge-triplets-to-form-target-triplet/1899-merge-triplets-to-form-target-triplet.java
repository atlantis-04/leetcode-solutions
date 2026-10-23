
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[3];

        for (int i = 0; i < triplets.length; i++) {

            if (triplets[i][0] > target[0] ||
                triplets[i][1] > target[1] ||
                triplets[i][2] > target[2]) {
                continue;
            }

            for (int j = 0; j < 3; j++) {
                max[j] = Math.max(max[j], triplets[i][j]);
            }
        }

        return Arrays.equals(max, target);
    }
}
