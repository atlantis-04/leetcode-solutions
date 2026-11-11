
class Solution {
    int count = 0;

    public int countSubstrings(String s) {
        generate(s, 0, 0);
        return count;
    }

    public void generate(String s, int start, int end) {
        if (start == s.length()) {
            return;
        }

        if (end == s.length()) {
            generate(s, start + 1, start + 1);
            return;
        }

        if (isPalindrome(s, start, end)) {
            count++;
        }

        generate(s, start, end + 1);
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
