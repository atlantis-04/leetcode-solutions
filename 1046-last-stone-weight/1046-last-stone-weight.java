class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : stones) {
            pq.offer(num);
        }

        // Continue while there is more than one stone to smash
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            if (first != second) {
                pq.offer(first - second);
            }
        }

        // If the queue is empty, all stones were destroyed; otherwise, return the last stone
        return pq.isEmpty() ? 0 : pq.poll();
    }
}