class Solution {
    public long subArrayRanges(int[] arr) {
         long sum = 0;
        int n = arr.length;
        // Generate all contiguous subarrays
        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            int maxVal = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] < minVal) minVal = arr[j];
                if (arr[j] > maxVal) maxVal = arr[j];
                sum += (maxVal - minVal);
            }
        }
        return sum;
    }
}