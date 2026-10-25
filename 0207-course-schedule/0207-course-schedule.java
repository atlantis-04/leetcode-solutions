class Solution {
    // apply topological sort using kahn algo
    public boolean canFinish(int v, int[][] graph) {
        // sbse pehle toh given pre-req ko ek graph me represent kro
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i< v;i++){
            list.add(new ArrayList<>());
        }

        for(int[] joins : graph){
            int course = joins[0];
            int req = joins[1];

            list.get(req).add(course);
        }

        int[] indegree = new int[v];
        for(int i = 0;i< v;i++){
            for(int it : list.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo.add(node);
            for(int it : list.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }

        if(topo.size() == v){
            return true;
        }

        return false;
    }
}