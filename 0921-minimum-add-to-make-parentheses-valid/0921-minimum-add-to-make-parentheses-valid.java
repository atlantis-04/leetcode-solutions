class Solution {
    public int minAddToMakeValid(String s) {
        if (s.length() == 0)
            return 0;

        int balance = 0;
        int insertions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;

                if (balance < 0) {
                    insertions++;
                    balance = 0;
                }
            }
        }

        // Any remaining '(' need a ')'
        insertions += balance;

        return insertions;
    }
}