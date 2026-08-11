class Solution {

    PriorityQueue<Integer> left =
        new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    HashMap<Integer, Integer> deleted = new HashMap<>();

    int leftSize = 0;
    int rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        // Add first k elements
        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = getMedian(k);

        // Slide window
        for (int i = k; i < n; i++) {

            // Remove outgoing element
            remove(nums[i - k]);

            // Add incoming element
            add(nums[i]);

            ans[i - k + 1] = getMedian(k);
        }

        return ans;
    }

    private void add(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
            leftSize++;
        } else {
            right.add(num);
            rightSize++;
        }

        balance();
    }

    private void remove(int num) {

        // Mark num for deletion
        deleted.put(num, deleted.getOrDefault(num, 0) + 1);

        // Decide which logical heap it belongs to
        if (!left.isEmpty() && num <= left.peek()) {
            leftSize--;
        } else {
            rightSize--;
        }

        clean(left);
        clean(right);

        balance();
    }

    private void balance() {

        // left can have at most 1 more element
        if (leftSize > rightSize + 1) {

            int num = left.poll();

            leftSize--;
            rightSize++;

            right.add(num);
        }

        else if (leftSize < rightSize) {

            int num = right.poll();

            rightSize--;
            leftSize++;

            left.add(num);
        }

        clean(left);
        clean(right);
    }

    private void clean(PriorityQueue<Integer> pq) {

        while (!pq.isEmpty()) {

            int num = pq.peek();

            if (deleted.containsKey(num)) {

                pq.poll();

                int count = deleted.get(num);

                if (count == 1) {
                    deleted.remove(num);
                } else {
                    deleted.put(num, count - 1);
                }

            } else {
                break;
            }
        }
    }

    private double getMedian(int k) {

        clean(left);
        clean(right);

        if (k % 2 == 1) {
            return (double) left.peek();
        }

        return ((double) left.peek() + right.peek()) / 2.0;
    }
}