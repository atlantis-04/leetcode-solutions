class Solution {
    public int minCost(int[] arr) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);
        }

        int sum = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int cost = a + b;
            sum += cost;

            pq.add(cost);
        }

        return sum;
    }
}