class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        // To store the next greater elements
        int[] ans = new int[n];

        // Stack to help find next greater elements in reverse traversal
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice in reverse to simulate circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int ind = i % n;
            int currEle = arr[ind];

            // Pop all elements from stack that are less than or equal to current
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }

            // Only fill result in the first pass (i < n)
            if (i < n) {
                if (st.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = st.peek();
                }
            }

            // Push current element to stack
            st.push(currEle);
        }

        return ans;
    }
}
