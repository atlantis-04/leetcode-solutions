class Solution {

    class Pair {
        int a;
        int b;
        int j;
        int sum;

        Pair(int a, int b, int j) {
            this.a = a;
            this.b = b;
            this.j = j;
            this.sum = a + b;
        }
    }

    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((x, y) -> x.sum - y.sum);

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new Pair(nums1[i], nums2[0], 0));
        }

        while (k > 0 && !pq.isEmpty()) {

            Pair p = pq.poll();

            result.add(Arrays.asList(p.a, p.b));

            if (p.j + 1 < nums2.length) {
                int nextJ = p.j + 1;

                pq.add(new Pair(
                    p.a,
                    nums2[nextJ],
                    nextJ
                ));
            }

            k--;
        }

        return result;
    }
}