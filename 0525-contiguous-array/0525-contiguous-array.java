class Solution {
    public int findMaxLength(int[] arr) {
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        int k = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If the sum from index 0 to i is k
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Check if (prefixSum - k) has occurred before
            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store the first occurrence of the prefix sum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}