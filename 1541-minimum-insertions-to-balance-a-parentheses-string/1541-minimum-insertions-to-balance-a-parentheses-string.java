class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        if (s.length() == 0)
            return 0;
        int ins = 0;
        int open = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '('){
                open++;

            }
            else{
                if(i +1 < s.length() && s.charAt(i+1) == ')'){
                    i++;
                }
                else{
                    ins++;
                }
                if(open > 0){
                    open--;
                }
                else{
                    ins++;
                }
            }
        }
        ins += open * 2;

        return ins;
    }
}