import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int p) {
        int n = tasks.length;

        HashMap<Character, Integer> mp = new HashMap<>();

        for (char ch : tasks) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Push frequencies
        for (int freq : mp.values()) {
            pq.add(freq);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            // Fill p + 1 positions
            for (int i = 1; i <= p + 1; i++) {

                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    temp.add(freq - 1);
                }
            }

            // Put unfinished tasks back into heap
            for (int freq : temp) {
                if (freq > 0) {
                    pq.add(freq);
                }
            }

            if (pq.isEmpty()) {
                // All tasks finished
                time += temp.size();
            } else {
                // We need the complete p + 1 block
                time += p + 1;
            }
        }

        return time;
    }
}