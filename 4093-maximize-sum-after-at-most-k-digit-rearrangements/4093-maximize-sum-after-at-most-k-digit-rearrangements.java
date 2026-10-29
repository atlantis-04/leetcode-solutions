class Solution {
    public long maximizeSum(int[] nums, int k) {
        PriorityQueue<Long>pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int ele:nums){
            sum+=ele;
            int[] freq = new int[10];
            int a = ele;
            while(a>0){
                freq[a%10]++;
                a/=10;
            }
            long max=0;
            for(int i=9;i>=0;i--){
                while(freq[i]>0){
                    max=max*10+i;
                    freq[i]--;
                }
            }
            long gain = max-ele;
            if(gain>0)pq.offer(gain);
        }
        while(k>0 && !pq.isEmpty()){
                sum+=pq.poll();
                k--;
            }
        return sum;
    }
}