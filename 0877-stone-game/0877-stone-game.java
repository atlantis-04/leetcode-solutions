class Solution {
    public boolean stoneGame(int[] arr) {
        // return true;
        int n = arr.length;
        int i = 0;
        int j = n-1;
        int a = 0;
        int b = 0;
        boolean flag = false;
        while(i < j){
            if(!flag){
                a+= Math.max(arr[i], arr[j]);
            }else{
                b+=Math.min(arr[i],arr[j]);
            }
            i++;
            j--;
        }

        if(a > b) return true;
        else return false;
    }
}