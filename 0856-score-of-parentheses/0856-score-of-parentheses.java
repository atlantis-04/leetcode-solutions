class Solution {
    public int scoreOfParentheses(String s) {
        int ct=0;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ct++;
            }
            else{
                if(s.charAt(i-1)=='('){
                    ans+=(int)Math.pow(2,ct-1);
                }
                ct--;
            }
        }
        return ans;
    }
}