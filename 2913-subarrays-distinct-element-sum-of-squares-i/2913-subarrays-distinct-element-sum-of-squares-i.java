
import java.util.*;

class Solution {
    static class SegmentTree {
        long[] sum, squareSum, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int left, int right, long val) {
            long len = right - left + 1;

            squareSum[node] += 2 * val * sum[node] + len * val * val;
            sum[node] += len * val;
            lazy[node] += val;
        }

        void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) return;

            int mid = left + (right - left) / 2;

            apply(node * 2, left, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, right, lazy[node]);

            lazy[node] = 0;
        }

        void update(int node, int left, int right,
                    int ql, int qr, long val) {

            if (qr < left || right < ql) return;

            if (ql <= left && right <= qr) {
                apply(node, left, right, val);
                return;
            }

            push(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, right, ql, qr, val);

            sum[node] = sum[node * 2] + sum[node * 2 + 1];
            squareSum[node] = squareSum[node * 2] + squareSum[node * 2 + 1];
        }
    }

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return 0;

        SegmentTree tree = new SegmentTree(n);
        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int prev = lastSeen.getOrDefault(num, -1);

            tree.update(1, 0, n - 1, prev + 1, i, 1);

            answer += tree.squareSum[1];

            lastSeen.put(num, i);
        }

        return (int) answer;
    }
}
