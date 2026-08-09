class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();

        int[] last = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] <= last[1]) {
                last[1] = Math.max(last[1], cur[1]); // merge
                // pehle last se matching jitne bhi curr milte hai unka end update krte rho
                // jaisi koi dusra interval ayga non merging wala to last ko list me add krke ab curr ko last banake sabse compare kro.
            } else {
                ans.add(last);  // add finished binge
                last = cur;     // start new binge
            }
        }

        ans.add(last); // don’t forget the last binge!
        return ans.toArray(new int[ans.size()][]);
    }
}