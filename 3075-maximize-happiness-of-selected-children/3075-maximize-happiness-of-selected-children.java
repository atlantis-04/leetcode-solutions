class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {

        Arrays.sort(happiness);

        long happy = 0;
        int n = happiness.length;

        for (int i = n - 1, turn = 0; turn < k; i--, turn++) {
            happy += Math.max(happiness[i] - turn, 0);
        }

        return happy;
    }
}