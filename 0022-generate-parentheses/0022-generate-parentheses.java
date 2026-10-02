class Solution {
   public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n <= 0) return res;
    backtrack(res, new StringBuilder(), 0, 0, n);
    return res;
}

private void backtrack(List<String> res, StringBuilder sb, int openUsed, int closeUsed, int n) {
    if (openUsed == n && closeUsed == n) {
        res.add(sb.toString());
        return;
    }

    if (openUsed < n) {
        sb.append('(');
        backtrack(res, sb, openUsed + 1, closeUsed, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    if (closeUsed < openUsed) {
        sb.append(')');
        backtrack(res, sb, openUsed, closeUsed + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}

}