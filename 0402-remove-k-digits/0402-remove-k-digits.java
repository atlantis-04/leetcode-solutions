class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();

        // Traverse the given string
        for (int i = 0; i < nums.length(); i++) {
            char digit = nums.charAt(i); // Current digit

            // Pop last digits if a smaller digit is found and k > 0
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // Remove the last digit
                k--; // Decrement k by 1
            }

            // Push the current digit
            st.push(digit);
        }

        // If more digits can be removed
        while (k > 0) {
            st.pop(); // Pop the last added digits
            k--; // Decrement k by 1
        }

        // Handle edge case: if stack is empty
        if (st.isEmpty())
            return "0";

        // StringBuilder to store the result
        StringBuilder res = new StringBuilder();

        // Add digits from stack to result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        // Trim the leading zeros
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        // Reverse the string to get the correct number
        res.reverse();

        // If result is empty, return "0"
        if (res.length() == 0)
            return "0";

        // Return the result as a string
        return res.toString();
    }
}
