class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;
         Arrays.sort(arr);
        Arrays.sort(dep);

        // Initialize counters and pointers
        int platforms = 1;
        int result = 1;
        int i = 1, j = 0;

        // Traverse both arrays
        while (i < n && j < n) {
            // If next train arrives before current one departs
            if (arr[i] <= dep[j]) {
                // One more platform needed
                platforms++;
                i++;
            } else {
                // One train departs, platform freed
                platforms--;
                j++;
            }

            // Update maximum required platforms
            result = Math.max(result, platforms);
        }

        return result;
    }
}
