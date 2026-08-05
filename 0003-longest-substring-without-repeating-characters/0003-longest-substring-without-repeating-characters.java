class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int n = s.length();
        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxlen = Math.max(maxlen,right-left +1);
                right++;
            }
            else{
                if(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return maxlen;
    }
}