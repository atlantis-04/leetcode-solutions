class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ele:asteroids){
            Boolean des = false;
            while(!st.isEmpty() && ele<0 && st.peek()>0){
                if(Math.abs(ele)>st.peek()){
                    st.pop();
                }
                else if(Math.abs(ele)==st.peek()){
                    st.pop();
                    des=true;break;
                }
                else{
                    des=true;
                    break;
                }
            }
            if(!des) st.push(ele);
        }
        int[] arr = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}