class Rank {
    int val;
    int index;

    public Rank(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] arrayRankTransform(int[] arr) {

        PriorityQueue<Rank> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Put all elements into min heap
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Rank(arr[i], i));
        }

        int rank = 0;
        int prev = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            Rank node = pq.poll();

            // Increase rank only when value changes
            if (node.val != prev) {
                rank++;
                prev = node.val;
            }

            arr[node.index] = rank;
        }

        return arr;
    }
}