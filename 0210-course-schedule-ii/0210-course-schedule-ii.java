class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];

            adj.get(prereq).add(course);
        }

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int next : adj.get(i)) {
                indegree[next]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();
            ans[idx++] = curr;

            for (int next : adj.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return idx == numCourses ? ans : new int[]{};
    }
}